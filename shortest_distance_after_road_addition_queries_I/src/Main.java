import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
//    You are given an integer n and a 2D integer array queries.
//
//There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.
//
//queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.
//
//Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            paths.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            paths.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            paths.get(queries[i][0]).add(queries[i][1]);
            result[i] = getShortestPath(n, paths);
        }
        return result;
    }

    private static int getShortestPath(int n, List<List<Integer>> paths) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return distance;
                }
                for (int neighbor : paths.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}