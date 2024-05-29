package mc.project.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class Main {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};

        pacificAtlantic(heights);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] canAccessPO = new boolean[rows][cols];
        boolean[][] canAccessAO = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, rows, cols, canAccessPO, i, 0, 0);
            dfs(heights, rows, cols, canAccessAO, i, cols - 1, 0);
        }

        for (int i = 0; i < cols; i++) {
            dfs(heights, rows, cols, canAccessPO, 0, i, 0);
            dfs(heights, rows, cols, canAccessAO, rows - 1, i, 0);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canAccessPO[i][j] && canAccessAO[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    public static void dfs(int[][] heights, int rows, int cols,
                    boolean[][] visited, int currentRow, int currentCol, int previousHeight) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= rows || currentCol >= cols ||
                visited[currentRow][currentCol] || previousHeight > heights[currentRow][currentCol]) {
            return;
        }
        visited[currentRow][currentCol] = true;

        dfs(heights, rows, cols, visited, currentRow - 1, currentCol, heights[currentRow][currentCol]);
        dfs(heights, rows, cols, visited, currentRow, currentCol - 1, heights[currentRow][currentCol]);
        dfs(heights, rows, cols, visited, currentRow + 1, currentCol, heights[currentRow][currentCol]);
        dfs(heights, rows, cols, visited, currentRow, currentCol + 1, heights[currentRow][currentCol]);
    }
}
