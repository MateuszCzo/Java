public class Main {
//    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int countSquares(int[][] matrix) {
        int result = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                int tempi = i - 1;
                int tempj = j - 1;
                int min = Math.min(
                        Math.min(matrix[tempi][j], matrix[i][tempj]),
                        matrix[tempi][tempj]);
                matrix[i][j] = min + 1;
            }
        }
        for (int[] ints : matrix) {
            for (int sInt : ints) {
                result += sInt;
            }
        }
        return result;
    }
}