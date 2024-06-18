package mc.project.validate_binary_search_tree;
/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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

    public static boolean isValidBST(TreeNode root) {
        return validateBranch(root.left, Long.MIN_VALUE, root.val) &&
                validateBranch(root.right, root.val, Long.MAX_VALUE);
    }

    public static boolean validateBranch(TreeNode root, long min, long max) {
        if (root == null) return true;

        return root.val > min && root.val < max &&
                validateBranch(root.left, min, root.val) &&
                validateBranch(root.right, root.val, max);
    }
}
