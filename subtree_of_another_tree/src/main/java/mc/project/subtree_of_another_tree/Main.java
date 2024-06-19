package mc.project.subtree_of_another_tree;

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSame(root, subRoot)) {
            return true;
        }

        return this.isSubtree(root.left, subRoot) ||
                this.isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if (root != null && subRoot != null && root.val == subRoot.val) {
            return this.isSame(root.left, subRoot.left) &&
                    this.isSame(root.right, subRoot.right);
        }
        return false;
    }
}
