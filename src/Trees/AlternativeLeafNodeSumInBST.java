package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
problem statement:
You need to build a BST from the given array A of size N. The array contains distinct elements. You need to build the tree using the
Array elements in the order of their arrival (A[0] becomes root and so on). Now, you need to sum the alternate leaf nodes of this BST
and print the result.
Note: Start from the left side of the tree when searching for leaf nodes. So sum leaftnode1+leaftnode3+leafnode5 ...

Input:
1
6
5 1 2 3 4 6
Output:
4

Explanation:
Testcase1:
The BST will look like :
            5
          /     \
        1        6
         \
            2
               \
                3
                    \
                        4
As it is evident from the above BST, the leaf nodes are 4 and 6. So sum of alternate leaf nodes would be 4.
 */
public class AlternativeLeafNodeSumInBST {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            long[] ar = new long[n];
            String[] line = bf.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                ar[i] = Long.parseLong(line[i]);
            }
            Node root = new Node(ar[0]);
            for (int i = 1; i < n; i++) {
                insert(root, ar[i]);
            }
            count = 1;
            inorder(root);
        }
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            if (root.left == null && root.right == null) {
                //System.out.println(root.data + " " + count);
                if (count % 2 == 1) {
                    System.out.print(root.data + " ");
                }
                count++;
            }
            inorder(root.right);
        }
    }

    private static Node insert(Node root, long data) {
        if (root == null)
            return new Node(data);
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static class Node {
        long data;
        Node left, right;

        Node(long data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
