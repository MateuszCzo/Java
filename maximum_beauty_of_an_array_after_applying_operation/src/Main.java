import java.util.Arrays;

public class Main {
//    You are given a 0-indexed array nums and a non-negative integer k.
//
//In one operation, you can do the following:
//
//Choose an index i that hasn't been chosen before from the range [0, nums.length - 1].
//Replace nums[i] with any integer from the range [nums[i] - k, nums[i] + k].
//The beauty of the array is the length of the longest subsequence consisting of equal elements.
//
//Return the maximum possible beauty of the array nums after applying the operation any number of times.
//
//Note that you can apply the operation to each index only once.
//
//A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the order of the remaining elements.
    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4,7,1,3}, 2));
    }

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDifference = 2 * k;

        int left = 0;
        int maxWindow = 1;
        for (int right = 0; right < nums.length; right++) {
            while (nums[left] < nums[right] - maxDifference) {
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}