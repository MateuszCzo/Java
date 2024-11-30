import java.util.*;

public class Main {
//    You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.
//
//Return any valid arrangement of pairs.
//
//Note: The inputs will be generated such that there exists a valid arrangement of pairs.
    public static void main(String[] args) {
        System.out.println(validArrangement(new int[][]{{5,1},{4,5},{11,9},{9,4}}));
    }

    public static int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> pairsMap = new HashMap<>();
        Map<Integer, Integer> inputs = new HashMap<>();
        Map<Integer, Integer> outputs = new HashMap<>();

        for (int[] pair : pairs) {
            List<Integer> list = pairsMap.getOrDefault(pair[0], new ArrayList<>());
            list.add(pair[1]);
            pairsMap.put(pair[0], list);
            outputs.put(pair[0], outputs.getOrDefault(pair[0], 0) + 1);
            inputs.put(pair[1], inputs.getOrDefault(pair[1], 0) + 1);
        }

        int start = 0;
        boolean found = false;
        for (int key : pairsMap.keySet()) {
            if (outputs.get(key) == inputs.getOrDefault(key, 0) + 1) {
                start = key;
                found = true;
                break;
            }
        }
        if (!found) {
            start = pairs[0][0];
        }

        List<Integer> path = new ArrayList<>();

        findPath(start, pairsMap, outputs, path);

        Collections.reverse(path);

        int[][] result = new int[pairs.length][2];
        for (int i = 0; i < path.size() - 1; i++) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        return result;
    }

    private static void findPath(int current, Map<Integer, List<Integer>> pairsMap, Map<Integer, Integer> outputs, List<Integer> path) {
        int next;
        while (outputs.getOrDefault(current, 0) > 0) {
            next = pairsMap.get(current).get(outputs.get(current) - 1);
            outputs.put(current, outputs.get(current) - 1);
            findPath(next, pairsMap, outputs, path);
        }
        path.add(current);
    }
}