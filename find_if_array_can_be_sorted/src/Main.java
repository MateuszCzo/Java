import java.util.*;

public class Main {
//    You are given a 0-indexed array of positive integers nums.
//
//In one operation, you can swap any two adjacent elements if they have the same number of
//set bits
//. You are allowed to do this operation any number of times (including zero).
//
//Return true if you can sort the array, else return false.
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{3,16,8,4,2}));
    }

    public static boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE;
        int currMax = nums[0];
        int currMin = nums[0];
        int currBitsCount = countSetBits(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int bitSize = countSetBits(nums[i]);
            if (currBitsCount == bitSize) {
                currMax = Math.max(currMax, nums[i]);
                currMin = Math.min(currMin, nums[i]);
            } else {
                if (prevMax > currMin) {
                    return false;
                }
                prevMax = currMax;
                currMax = nums[i];
                currMin = nums[i];
                currBitsCount = bitSize;
            }
        }
        if (prevMax > currMin) {
            return false;
        }
        return true;
    }

    public static int countSetBits(int number) {
        int result = 0;
        while (number > 0) {
            result += number & 1;
            number >>= 1;
        }
        return result;
    }
}