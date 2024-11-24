public class Main {
//    You are given an n x n integer matrix. You can do the following operation any number of times:
//
//Choose any two adjacent elements of matrix and multiply each of them by -1.
//Two elements are considered adjacent if and only if they share a border.
//
//Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
    public static void main(String[] args) {
        System.out.println(maxMatrixSum(new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}}));
    }

    public static long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) negativeCount++;
                int current = Math.abs(num);
                if (min > current) min = current;
                result += current;
            }
        }
        if (negativeCount % 2 == 1) {
            result -= 2L * min;
        }
        return result;
    }
}