import java.util.HashMap;
import java.util.Map;

public class Main {
//    The bitwise AND of an array nums is the bitwise AND of all integers in nums.
//
//For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
//Also, for nums = [7], the bitwise AND is 7.
//You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. Each number in candidates may only be used once in each combination.
//
//Return the size of the largest combination of candidates with a bitwise AND greater than 0.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int largestCombination(int[] candidates) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1<<i;
            int count = 0;
            for (int candidate : candidates) {
                if ((candidate & bit) > 0) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}