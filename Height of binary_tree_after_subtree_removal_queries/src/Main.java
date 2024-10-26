import java.util.ArrayList;

public class Main {

    //You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.
    //
    //You have to perform m independent queries on the tree where in the ith query you do the following:
    //
    //Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
    //Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.
    //
    //Note:
    //
    //The queries are independent, so the tree returns to its initial state after each query.
    //The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

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

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int length = 100001;
        int[] levels = new int[length];
        int[] heights = new int[length];
        int[][] top2Heights = new int[length][2];

        int[] result = new int[queries.length];

        helper(root, levels, heights, top2Heights, 0);

        for (int i = 0; i < queries.length; i++) {
            int removing = queries[i];
            int level = levels[removing];
            int height = heights[removing];
            int maxHeight = (height == top2Heights[level][0]) ?
                    top2Heights[level][1] :
                    top2Heights[level][0];
            result[i] = maxHeight + level - 1;
        }

        return result;
    }

    private static int helper(TreeNode root, int[] levels, int[] heights, int[][] top2Heights, int level) {
        if (root == null) {
            return 0;
        }

        int height = 1 + Math.max(
                helper(root.left, levels, heights, top2Heights, level + 1),
                helper(root.right, levels, heights, top2Heights, level + 1)
        );

        levels[root.val] = level;
        heights[root.val] = height;

        if (height > top2Heights[level][0]) {
            top2Heights[level][1] = top2Heights[level][0];
            top2Heights[level][0] = height;
        } else if (height > top2Heights[level][1]) {
            top2Heights[level][1] = height;
        }

        return height;
    }
}