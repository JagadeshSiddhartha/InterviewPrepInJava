package Trees;
import java.util.*;
import java.io.*;
import java.lang.*;

class TreeTopView
{
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

            new View().topView(root);
            System.out.println();
            t--;

        }
    }
}
class View
{
    // function should print the topView of the binary tree
    static void topView(Node node)
    {
        class NodePair {
            Node node;
            int level;
            NodePair(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        Queue<NodePair> que = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();
        que.add(new NodePair(node, 0));

        while(!que.isEmpty()) {
            NodePair pair = que.poll();
//            System.out.println(pair.node.data+ " " + pair.level);
            if(!map.containsKey(pair.level)) {
                map.put(pair.level, pair.node);
//                System.out.print(pair.node.data+ " ");
            }
            if(pair.node.left != null) que.add(new NodePair(pair.node.left, pair.level - 1));
            if(pair.node.right != null) que.add(new NodePair(pair.node.right, pair.level + 1));
        }
        for(int key : map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }
    }
}

