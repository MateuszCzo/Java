package mc.project.serialize_and_seserialize_binary_tree;

import java.util.LinkedList;
import java.util.List;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
public class Main {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static String serialize(TreeNode root) {
        List<String> treeValues = new LinkedList<>();
        serializeTree(root, treeValues);
        return String.join(",", treeValues);
    }

    protected static void serializeTree(TreeNode root, List<String> treeValues) {
        if (root == null) {
            treeValues.add("N");
            return;
        }
        treeValues.add(Integer.toString(root.val));
        serializeTree(root.left, treeValues);
        serializeTree(root.right, treeValues);
    }

    public static TreeNode deserialize(String data) {
        String[] numbers = data.split(",");
        index = 0;
        return deserializeToTreeNode(numbers);
    }

    protected static int index;

    protected static TreeNode deserializeToTreeNode(String[] numbers) {
        if (numbers[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(numbers[index]));

        index++;
        root.left = deserializeToTreeNode(numbers);
        root.right = deserializeToTreeNode(numbers);

        return root;
    }
}
