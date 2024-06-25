package mc.project.set_matrix_zeros;

public class Main {
    public static void main(String[] args) {
    }

    public static void setZeroes(int[][] matrix) {
        int lengthY = matrix.length, lengthX = matrix[0].length;
        boolean firstCol = false;
        boolean firstRow = false;

        // whether the first column should be set to 0
        for (int i = 0; i < lengthY; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        // whether the first row should be set to 0
        for (int i = 0; i < lengthX; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        // whether the i column and j row should be set to 0
        for (int i = 1; i < lengthY; i++) {
            for (int j = 1; j < lengthX; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set i column to 0
        for (int i = 1; i < lengthY; i++) {
            if (matrix[i][0] != 0) {
                continue;
            }
            for (int j = 1; j < lengthX; j++) {
                matrix[i][j] = 0;
            }
        }

        // set i row to 0
        for (int i = 1; i < lengthX; i++) {
            if (matrix[0][i] != 0) {
                continue;
            }
            for (int j = 1; j < lengthY; j++) {
                matrix[j][i] = 0;
            }
        }

        // set first column to 0
        if (firstCol) {
            for (int i = 0; i < lengthY; i++) {
                matrix[i][0] = 0;
            }
        }
        // set first row to 0
        if (firstRow) {
            for (int i = 0; i < lengthX; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
