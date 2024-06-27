package mc.project.non_overlaping_intervals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{1,2},{3,4}};

        eraseOverlapIntervals(intervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (array1, array2) -> array1[0] - array2[0]);

        int currentMax = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currentMax) {
                result++;
            }
            currentMax = Math.min(intervals[i][1], currentMax);
        }

        return result;
    }
}
