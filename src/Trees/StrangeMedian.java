package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StrangeMedian {
    static Node node;
    static int cnt;

    static Node insertInBST(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insertInBST(root.left, key);
        else root.right = insertInBST(root.right, key);
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            Node root = null;
            inputLine = br.readLine().trim().split(" ");
            root = insertInBST(root, Integer.parseInt(inputLine[0]));
            for (int i = 1; i < n; i++) {
                insertInBST(root, Integer.parseInt(inputLine[i]));
            }
            System.out.println(median(root, k));
        }
    }

    private static int median(Node root, int k) {
        if (root == null) return -1;
        cnt = 1;
        ini(root, k);
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        inorder(node, list);

        int size = list.size();
        if (size % 2 == 0) {
            size /= 2;
            return (list.get(size - 1) + list.get(size)) / 2;
        } else {
            return list.get(size / 2);
        }
    }

    private static void ini(Node root, int k) {
        if (root != null) {
            ini(root.left, k);
            if (cnt == k) { node = root; return;}
            cnt++;
            ini(root.right, k);
        }
    }

    private static void inorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            this.data = key;
            this.left = this.right = null;
        }
    }
}
