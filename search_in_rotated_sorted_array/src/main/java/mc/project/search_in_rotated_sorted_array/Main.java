package mc.project.search_in_rotated_sorted_array;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int target = 5;

        search(nums, target);
    }

    public static int search(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        int middleIndex;
        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            }
            if (nums[firstIndex] <= nums[middleIndex]) {
                if (nums[firstIndex] <= target && target < nums[middleIndex]) {
                    lastIndex = middleIndex - 1;
                } else {
                    firstIndex = middleIndex + 1;
                }
            } else {
                if (nums[middleIndex] < target && target <= nums[lastIndex]) {
                    firstIndex = middleIndex + 1;
                } else {
                    lastIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
}
