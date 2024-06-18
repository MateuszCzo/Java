package mc.project.construct_binary_tree_from_inorder_and_inorder_traversal;

import java.util.*;

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
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};

        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapping = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>(Arrays.stream(preorder).boxed().toList());

        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        return build(mapping, deque, 0, preorder.length - 1);
    }

    public static TreeNode build(Map<Integer, Integer> mapping, Deque<Integer> deque, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(deque.pollFirst());
        int mid = mapping.get(root.val);

        root.left = build(mapping, deque, start, mid - 1);
        root.right = build(mapping, deque, mid + 1, end);

        return root;
    }
}
