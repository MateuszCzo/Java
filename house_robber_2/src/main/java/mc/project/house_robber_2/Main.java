package mc.project.house_robber_2;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2};

        rob(nums);
    }

    public static int rob(int[] nums) {
        int length = nums.length;

        if (length == 1) return nums[0];

        return Math.max(findSubMax(nums, 0, length - 2), findSubMax(nums, 1, length - 1));
    }

    public static int findSubMax(int[] nums, int indexStart, int indexEnd) {
        int temp;
        int maxRob = 0;
        int maxNei = 0;

        for (int i = indexStart; i <= indexEnd; i++) {
            temp = Math.max(maxRob, nums[i] + maxNei);
            maxNei = maxRob;
            maxRob = temp;
        }
        return maxRob;
    }
}
