import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
//    You are given an m x n binary matrix matrix.
//
//You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
//
//Return the maximum number of rows that have all values equal after some number of flips.
    public static void main(String[] args) {
        System.out.println(maxEqualRowsAfterFlips(new int[][]{{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> frequencymap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[i][0]) {
                    stringBuilder.append('1');
                } else {
                    stringBuilder.append('0');
                }
            }

            String key = stringBuilder.toString();

            frequencymap.put(key, frequencymap.getOrDefault(key, 0) + 1);
        }
        return frequencymap.values().stream().max(Integer::compareTo).get();
    }
}