package Trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;

public class SpiralLevelOrder {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Node root=null;
        while (t-- > 0) {
            HashMap<Integer, Node> m = new HashMap<>();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            //printSpiral(root);
            //System.out.println(maxWidth(root));
            topView(root);
            System.out.println();
        }
    }

    static void leftView(Node node) {
        if (node == null) return;
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                Node top = que.poll();
                if (i == 0) {
                    System.out.print(top.data + " ");
                }
                if (top.left != null) que.add(top.left);
                if (top.right != null) que.add(top.right);
            }
        }
    }

    void rightView(Node node) {
        if (node == null) return;
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                Node top = que.poll();
                if (i == sz - 1) {
                    System.out.print(top.data + " ");
                }
                if (top.left != null) que.add(top.left);
                if (top.right != null) que.add(top.right);
            }
        }
    }

    static void topView(Node node) {
        if (node == null) return;
        class pair {
            final Node n;
            final Integer level;

            pair(Node n, int level) {
                this.n = n;
                this.level = level;
            }
        }

        /*
        If sorted from left to right printing is needed, use TreeMap;
        HashSet is enough for topView, using HashMap since
        same code can be used for bottom view also, with minute changes;
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(node, 0));
        while (!q.isEmpty()) {
            pair top = q.poll();
            if (!map.containsKey(top.level)) {
                System.out.print(top.n.data + " ");
                map.put(top.level, top.n.data);
            }
            if (top.n.left != null) q.add(new pair(top.n.left, top.level - 1));
            if (top.n.right != null) q.add(new pair(top.n.right, top.level + 1));
        }
        System.out.println();
    }

    static void bottomView(Node node) {
        if (node == null) return;
        class pair {
            Node n;
            Integer level;

            pair(Node n, int level) {
                this.n = n;
                this.level = level;
            }
        }


        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(node, 0));
        while (!q.isEmpty()) {
            pair top = q.poll();
            map.put(top.level, top.n.data);
            if (top.n.left != null) q.add(new pair(top.n.left, top.level - 1));
            if (top.n.right != null) q.add(new pair(top.n.right, top.level + 1));
        }
        for (Integer key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    static int maxWidth(Node node) {
        if (node == null) return 0;
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        int maxWidth = 1;
        while (que.size() > 0) {
            int n = que.size();
            maxWidth = Math.max(maxWidth, n);
            while (n-- > 0) {
                Node top = que.poll();
                if (top.left != null) que.add(top.left);
                if (top.right != null) que.add(top.right);
            }
        }
        return maxWidth;
    }

    static void printSpiral(Node node) {
        if (node == null) return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.add(node);
        while (!st1.isEmpty() || !st2.isEmpty()) {
            if (st2.empty()) {
                while (!st1.empty()) {
                    Node top = st1.pop();
                    if (top.right != null) {
                        st2.push(top.right);
                    }
                    if (top.left != null) {
                        st2.push(top.left);
                    }

                    System.out.print(top.data + " ");
                }
            } else {
                while (!st2.empty()) {
                    Node top = st2.pop();
                    if (top.left != null) {
                        st1.push(top.left);
                    }
                    if (top.right != null) {
                        st1.push(top.right);
                    }


                    System.out.print(top.data + " ");
                }
            }
        }
        System.out.println();
    }

    static Node lca(Node root, int n1, int n2) {
        return null
                ;

    }
}
