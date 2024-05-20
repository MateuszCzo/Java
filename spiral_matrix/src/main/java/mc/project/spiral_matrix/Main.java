package mc.project.spiral_matrix;

import java.util.LinkedList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4},{5,6},{7,8}};

        spiralOrder(nums);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int lengthX = matrix[0].length;
        int lastIndexX = lengthX - 1;
        int lengthY = matrix.length;
        int lastIndexY = lengthY - 1;
        int iterations = Math.min(lastIndexY / 2, lastIndexX / 2);
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i <= iterations; i++) {
            readRow(list, matrix[i], i, lastIndexX - i, true);
            readColumn(list, matrix, lastIndexX - i, i + 1, lastIndexY - i,  true);
            if (i >= lengthY / 2 || i >= lengthX / 2) break;
            readRow(list, matrix[lastIndexY - i], lastIndexX - i - 1, i, false);
            readColumn(list, matrix, i, lastIndexY - i - 1, i + 1, false);
        }

        return list;
    }

    public static void readRow(List<Integer> list, int[] nums, int start, int stop, boolean leftToRight) {
        if (leftToRight) {
            for (int i = start; i <= stop; i++) {
                list.add(nums[i]);
            }
        } else {
            for (int i = start; i >= stop; i--) {
                list.add(nums[i]);
            }
        }
    }

    public static void readColumn(List<Integer> list, int[][] nums, int columnIndex, int start, int stop, boolean TopDown) {
        if (TopDown) {
            for (int i = start; i <= stop; i++) {
                list.add(nums[i][columnIndex]);
            }
        } else {
            for (int i = start; i >= stop; i--) {
                list.add(nums[i][columnIndex]);
            }
        }
    }
}
