package mc.project.number_of_islands;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Main {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        int val = numIslands(grid);
        System.out.println(val);
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public static void dfs(char[][] grid, int currentRow, int currentCol) {
        if (currentRow < 0 ||
                currentCol < 0 ||
                currentRow >= grid.length ||
                currentCol >= grid[0].length ||
                grid[currentRow][currentCol] == '0') {
            return;
        }
        grid[currentRow][currentCol] = '0';
        dfs(grid, currentRow - 1, currentCol);
        dfs(grid, currentRow + 1, currentCol);
        dfs(grid, currentRow, currentCol - 1);
        dfs(grid, currentRow, currentCol + 1);
    }
}
