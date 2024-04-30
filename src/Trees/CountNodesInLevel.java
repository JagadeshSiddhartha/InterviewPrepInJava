package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNodesInLevel {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            int lvl = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null) root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L') parent.left = child;
                else parent.right = child;
                m.put(n2, child);
                n--;
            }

            System.out.println(Count(root, lvl));
        }
    }

    static int Count(Node root, int lvl) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int layer = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            if (layer == lvl) {
                return size;
            }
            for (int i = 0; i < size; i++) {
                Node top = qu.poll();
                if (top.left != null) qu.add(top.left);
                if (top.right != null) qu.add(top.right);
            }
            layer++;
        }
        return 0;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
