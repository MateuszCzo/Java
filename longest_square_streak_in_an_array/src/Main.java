import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
//  You are given an integer array nums. A subsequence of nums is called a square streak if:
//
//  The length of the subsequence is at least 2, and
//  after sorting the subsequence, each element (except the first element) is the square of the previous number.
//  Return the length of the longest square streak in nums, or return -1 if there is no square streak.
//
//  A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int longestSquareStreak(int[] nums) {
        Set<Long> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add((long)num);
        }
        Map<Long, Integer> mem = new HashMap<>();
        int result = -1;
        for (int num : nums) {
            if (!mem.containsKey((long)num) && numsSet.contains((long)num * num)) {
                result = Math.max(result, 2 + maxChainSize((long)num * num, numsSet, mem));
            }
        }
        return result;
    }

    private static int maxChainSize(long num, Set<Long> numsSet, Map<Long, Integer> mem) {
        if (mem.containsKey(num)) {
            return mem.get(num);
        }
        int result = 0;
        if (numsSet.contains(num * num)) {
            result = 1 + maxChainSize(num * num, numsSet, mem);
        }
        mem.put(num, result);
        return result;
    }
}