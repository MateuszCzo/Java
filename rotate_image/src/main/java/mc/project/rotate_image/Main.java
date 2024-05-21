package mc.project.rotate_image;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        float length = matrix.length / 2f;
        int lastIndex = matrix.length - 1;

        for (int i = 0; i < length; i++) {
            int length2 = matrix.length - (2 * i) - 1;
            for (int j = 0; j < length2; j++) {
                rotateOnePixel(
                        matrix,
                        i, i + j,
                        i + j, lastIndex - i,
                        lastIndex - i, lastIndex - i - j,
                        lastIndex - i - j, i
                );
            }
        }
    }

    public static void rotateOnePixel(int[][] matrix,
                                      int indexY1, int indexX1,
                                      int indexY2, int indexX2,
                                      int indexY3, int indexX3,
                                      int indexY4, int indexX4) {
        int temp = matrix[indexY1][indexX1];
        matrix[indexY1][indexX1] = matrix[indexY4][indexX4];
        matrix[indexY4][indexX4] = matrix[indexY3][indexX3];
        matrix[indexY3][indexX3] = matrix[indexY2][indexX2];
        matrix[indexY2][indexX2] = temp;
    }
}
