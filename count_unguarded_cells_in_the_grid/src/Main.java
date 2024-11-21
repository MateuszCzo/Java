import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
//
//A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
//
//Return the number of unoccupied cells that are not guarded.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] guard : guards) {
            for (int[] direction : directions) {
                dfs(grid, m - 1, n - 1, guard[0] + direction[0], guard[1] + direction[1], direction);
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, int maxX, int maxY, int posX, int posY, int[] direction) {
        if (posX < 0 || posX > maxX || posY < 0 || posY > maxY || grid[posX][posY] >= 2) {
            return;
        }

        grid[posX][posY] = 1;

        dfs(grid, maxX, maxY, posX + direction[0], posY + direction[1], direction);
    }

}