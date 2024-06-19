package mc.project.maximum_depth_of_binary_tree;
/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Main {
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

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = this.maxDepth(root.left);
        int right = this.maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
