package mc.project.maximum_subarray;
/*
Given an integer array nums, find the subarray
with the largest sum, and return its sum.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int total = 0;
        int result = nums[0];

        for (int num : nums) {
            if (total < 0) {
                total = num;
            } else {
                total += num;
            }
            if (total > result) {
                result = total;
            }
        }

        return result;
    }
}
