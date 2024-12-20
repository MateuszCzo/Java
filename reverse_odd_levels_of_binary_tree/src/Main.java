import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
//    Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
//
//For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
//Return the root of the reversed tree.
//
//A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
//
//The level of a node is the number of edges along the path between it and the root node.
    public static void main(String[] args) {
        TreeNode t8 = new TreeNode(8);
        TreeNode t13 = new TreeNode(13);
        TreeNode t3 = new TreeNode(3, t8, t13);
        TreeNode t21 = new TreeNode(21);
        TreeNode t34 = new TreeNode(34);
        TreeNode t5 = new TreeNode(5, t21, t34);
        TreeNode t2 = new TreeNode(2, t3, t5);

        reverseOddLevels(t2);
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

    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                levelNodes.add(curr);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            if ((level & 1) == 1) {
                int size = levelNodes.size();
                for (int i = 0; i < size / 2; i++) {
                    TreeNode left = levelNodes.get(i);
                    TreeNode right = levelNodes.get(size - i - 1);
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
            }
            level++;
        }

        return root;
    }
}