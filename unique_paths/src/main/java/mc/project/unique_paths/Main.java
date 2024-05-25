package mc.project.unique_paths;
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class Main {
    public static void main(String[] args) {
        int m = 3, n = 7;
        uniquePaths(m, n);
    }

    public static int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            uniquePaths[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            uniquePaths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                uniquePaths[i][j] = uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
            }
        }

        return uniquePaths[m - 1][n - 1];
    }
}
