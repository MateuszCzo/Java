import java.util.ArrayList;
import java.util.List;

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
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode6;
        treeNode8.left = treeNode2;
        treeNode8.right = treeNode1;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;
        treeNode9.left = treeNode3;
        treeNode9.right = treeNode7;

        System.out.println(kthLargestLevelSum(treeNode5, 2));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> result = new ArrayList<>();
        helper(root, 0, result);
        result.sort(Long::compareTo);
        if (result.size() < k) {
            return -1;
        }
        return result.get(result.size() - k);
    }

    private static void helper(TreeNode root, int level, List<Long> sums) {
        if (root == null) {
            return;
        }
        if (sums.size() == level) {
            sums.add(level, (long)root.val);
        } else {
            sums.set(level, sums.get(level) + root.val);
        }
        helper(root.left, ++level, sums);
        helper(root.right, level, sums);
    }
}