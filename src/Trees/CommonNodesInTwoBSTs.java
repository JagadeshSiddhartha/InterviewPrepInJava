package Trees;

import java.lang.Math;
import java.util.*;

public class CommonNodesInTwoBSTs {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n1 = sc.nextInt();
            Node root1 = null;
            Node root2 = null;
            for (int i = 0; i < n1; i++) {
                int a = sc.nextInt();
                if (root1 == null)
                    root1 = new Node(a);
                else {
                    insert(root1, a);
                }
            }
            int n2 = sc.nextInt();
            for (int i = 0; i < n2; i++) {
                int a = sc.nextInt();
                if (root2 == null)
                    root2 = new Node(a);
                else {
                    insert(root2, a);
                }
            }
            printCommon(root1, root2);
            System.out.println();
        }
    }

    public static Node insert(Node root, int a) {
        if (root == null)
            return new Node(a);
        if (root.data > a) {
            root.left = insert(root.left, a);
        }
        if (root.data < a)
            root.right = insert(root.right, a);
        return root;
    }

    static public HashSet<Integer> firstSet;
    static boolean first;

    private static void printCommon(Node root1, Node root2) {
        firstSet = new HashSet<>();
        first = true;
        inorder(root1);
        first = false;
        inorder(root2);
    }

    private static void inorder(Node root) {
        if (root != null) {
            if (root.left != null) inorder(root.left);
            if (first) firstSet.add(root.data);
            else if (firstSet.contains(root.data)) System.out.println(root.data);
            if (root.right != null) inorder(root.right);
        }
    }
}
