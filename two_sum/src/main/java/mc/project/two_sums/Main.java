package mc.project.two_sums;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        long startTime = System.currentTimeMillis();

        int[] val = twoSum2(nums, target);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val[0]);
        System.out.println(val[1]);
    }

    // brute force solution
    public static int[] twoSum(int[] nums, int target) {
        int[] nums2 = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    nums2[0] = i;
                    nums2[1] = j;
                    return nums2;
                }
            }
        }
        return nums2;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            if (hashMap.containsKey(key)) {
                return new int[]{hashMap.get(key), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
