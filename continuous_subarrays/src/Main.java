public class Main {
//    You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
//
//Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
//Return the total number of continuous subarrays.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }

    public static long continuousSubarrays(int[] nums) {
        int windowMin = Integer.MAX_VALUE;
        int windowMax = Integer.MIN_VALUE;
        long count = 0;
        int left = 0;
        int right;
        int windowSize;
        for (right = 0; right < nums.length; right++) {
            windowMin = Math.min(windowMin, nums[right]);
            windowMax = Math.max(windowMax, nums[right]);

            if (windowMax - windowMin <= 2) continue;

            windowSize = right - left;
            count += ((long) windowSize * (windowSize + 1)) / 2;
            left = right;
            windowMin = nums[right];
            windowMax = nums[right];
            while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                left--;
                windowMin = Math.min(windowMin, nums[left]);
                windowMax = Math.max(windowMax, nums[left]);
            }
            if (left < right) {
                windowSize = right - left;
                count -= ((long) windowSize * (windowSize + 1)) / 2;
            }
        }
        windowSize = right - left;
        count += ((long) windowSize * (windowSize + 1)) / 2;

        return count;
    }
}