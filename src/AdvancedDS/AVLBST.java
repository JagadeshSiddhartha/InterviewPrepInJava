package AdvancedDS;

public class AVLBST {
    class Node {
        int height = 1;
        Node left = null;
        Node right = null;
        int data = 0;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
    Node root;

    int height(Node n) {
        if(n == null)return 0;
        return n.height;
    }
    int getBalance(Node N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node root, int data) {
        if(root ==null) {
            return new Node(data);
        }
        if(data > root.data)
            root.right = insert(root.right, data);
         else if(data < root.data)
            root.left = insert(root.left, data);
         else
            return root;
        root.height = Math.max(height(root.left) , height(root.right)) + 1;
        int balance = getBalance(root);
        if(balance > 1) {
            if(root.left.data > data) {
                return rightRotate(root);
            }
        }
        if(balance < -1 && root.right.data < data) {
            return leftRotate(root);
        }
        if(balance > 1 && root.left.data < data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance < -1 && root.right.data > data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return  root;
    }

    private Node rightRotate(Node root) {
        Node le = root.left;
        Node leri = le.right;
        le.right = root;
        root.left = leri;

        le.height = Math.max(le.left.height , le.right.height) + 1;
        root.height = Math.max(root.left.height , root.right.height) + 1;
        return le;
    }

    private Node leftRotate(Node root) {
        Node y = root.right;
        Node yl = y.left;
        y.left = root;
        root.right = yl;

        y.height = Math.max(y.left.height , y.right.height) + 1;
        root.height = Math.max(root.left.height , root.right.height) + 1;
        return y;
    }


    public static void main(String[] args) {
        AVLBST tree = new AVLBST();
        tree.root = tree.insert(tree.root, 2);

    }
}
