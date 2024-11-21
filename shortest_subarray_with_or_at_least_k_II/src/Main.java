import java.util.ArrayList;
import java.util.List;

public class Main {
//    You are given an array nums of non-negative integers and an integer k.
//
//An array is called special if the bitwise OR of all of its elements is at least k.
//
//Return the length of the shortest special non-empty
//subarray
// of nums, or return -1 if no special subarray exists.
//
//
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1, 2}, 4));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }

        int length = nums.length;
        int shortest = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int currOR = 0;
        int[] bitFreq = new int[32];

        while (right < length) {
            updateFreq(bitFreq, nums[right], 1);
            currOR |= nums[right];

            while (left <= right && currOR >= k) {
                shortest = Math.min(shortest, right - left + 1);
                updateFreq(bitFreq, nums[left], -1);
                currOR = getNumber(bitFreq);
                left++;
            }
            right++;
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private static void updateFreq(int[] bitFreq, int number, int val) {
        int counter = 0;
        while(number > 0) {
            if ((number & 1) == 1) {
                bitFreq[counter] += val;
            }
            counter++;
            number>>=1;
        }
    }

    private static int getNumber(int[] bitFreq) {
        int number = 0;
        long pow = 1;
        for (int i = 0; i < 32; ++i) {
            if (bitFreq[i] > 0) {
                number += pow;
            }
            pow *= 2;
        }
        return number;
    }
}