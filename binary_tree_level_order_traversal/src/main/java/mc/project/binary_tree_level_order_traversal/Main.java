package mc.project.binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        lists = new LinkedList<>();

        addNodeToList(root, 0);

        return lists;
    }

    private static List<List<Integer>> lists;

    protected static void addNodeToList(TreeNode root, int level) {
        if (root == null) return;

        List<Integer> list;
        if (lists.size() > level) {
            list = lists.get(level);
            list.add(root.val);
        } else {
            list = new LinkedList<>();
            list.add(root.val);
            lists.add(level, list);
        }

        addNodeToList(root.left, level + 1);
        addNodeToList(root.right, level + 1);
    }
}
