package Trees;

public class InvertionOfTree {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            TreeNode base = root;
            invert(root);
            return base;
        }
        public void invert(TreeNode root) {
            // System.out.println(root.val);
            if(root == null)return;
            if(root.left != null && root.right != null) {
                TreeNode tem = root.right;
                root.right = root.left;
                root.left = tem;
                invertTree(root.left);
                invertTree(root.right);
            } else if(root.left != null) {
                root.right = root.left;
                root.left = null;
                invertTree(root.right);
            } else if(root.right != null) {
                root.left = root.right;
                root.right = null;
                invertTree(root.left);
            }
        }
    }
}
