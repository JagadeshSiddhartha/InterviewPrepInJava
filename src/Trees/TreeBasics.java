package Trees;

// INITIAL CODE
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class TreeBasics
{


    // driver function to test the above functions
    public static void main(String args[])
    {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
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

            Level_order_traversal g = new Level_order_traversal();
            g.levelOrder(root);
            System.out.println();
            t--;

        }
    }
}
class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder(Node node)
    {
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()) {
            Node top = que.poll();
            System.out.print(node.data+" ");
            if(top.left  != null)que.add(top.left);
            if(top.right != null) que.add(top.right);
        }
        Stack<Integer> st  = new Stack<>();



    }
}
