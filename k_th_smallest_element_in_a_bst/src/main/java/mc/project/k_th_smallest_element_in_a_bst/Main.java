package mc.project.k_th_smallest_element_in_a_bst;

import java.util.Stack;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class Main {
    static public class TreeNode {
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

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode result = new TreeNode();
        findKthSmallestElement(root, 0, k, result);
        return result.val;
    }

    protected static int findKthSmallestElement(TreeNode currentNode, int prevElemAmount, int k, TreeNode result) {
        if (currentNode == null) {
            return prevElemAmount;
        }

        int leftElemAmount = findKthSmallestElement(currentNode.left, prevElemAmount, k, result);
        // no need to check the rest of the tree
        if (leftElemAmount >= k) {
            return leftElemAmount;
        }

        int currElementNumber = leftElemAmount + 1;

        if (currElementNumber == k) {
            result.val = currentNode.val;
            // no need to check the rest of the tree
            return currElementNumber;
        }

        return findKthSmallestElement(currentNode.right, currElementNumber, k, result);
    }

    public static int kthSmallest2(TreeNode root, int k) {
        int currentElement = 0;
        TreeNode currnetNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || currnetNode != null) {
            while (currnetNode != null) {
                stack.add(currnetNode);
                currnetNode = currnetNode.left;
            }
            currnetNode = stack.pop();
            currentElement++;
            if (currentElement == k) {
                break;
            }
            currnetNode = currnetNode.right;
        }

        return currnetNode.val;
    }
}
