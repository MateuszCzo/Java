package mc.project.house_robber;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};

        rob(nums);
    }

    public static int rob(int[] nums) {
        int length = nums.length;

        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int[] money = new int[length];
        money[0] = nums[0];
        money[1] = nums[1];
        money[2] = nums[0] + nums[2];

        for (int i = 3; i < length; i++) {
            money[i] = Math.max(money[i - 2], money[i - 3]) + nums[i];
        }

        return Math.max(money[length - 1], money[length - 2]);
    }
}
