package mc.project.maximum_product_subarray;
/*
Given an integer array nums, find a
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,-2,4};

        int val = maxProduct(nums);
        System.out.println(val);
    }

    public static int maxProduct(int[] nums) {
        int maximum = nums[0];
        int minimum = nums[0];
        int result = nums[0];
        int length = nums.length;
        int tempMaximum;

        for (int i = 1; i < length; i++) {
            int current = nums[i];

            tempMaximum = Math.max(current,
                    Math.max(maximum * current, minimum * current));

            minimum = Math.min(current,
                    Math.min(maximum * current, minimum * current));

            maximum = tempMaximum;

            result = Math.max(result, maximum);
        }

        return result;
    }
}
