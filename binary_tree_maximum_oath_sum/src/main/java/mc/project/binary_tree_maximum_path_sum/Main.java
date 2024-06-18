package mc.project.binary_tree_maximum_path_sum;

public class Main {
    public static class TreeNode {
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

    private static int maxPathSum;

    public static int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;

        findMaxPathSum(root);

        return maxPathSum;
    }

    public static int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return -1001;
        }
        int maxLeft = findMaxPathSum(root.left);
        int maxRight = findMaxPathSum(root.right);

        int[] potentialMaxPathSum = {
                root.val,
                maxLeft,
                maxRight,
                maxLeft + root.val,
                maxRight + root.val,
                maxLeft + maxRight + root.val,
        };

        for(int value : potentialMaxPathSum) {
            if (maxPathSum < value) {
                maxPathSum = value;
            }
        }

        return Math.max(Math.max(maxLeft, maxRight) + root.val, root.val);
    }
}
