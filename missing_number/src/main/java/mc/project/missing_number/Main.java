package mc.project.missing_number;

import java.util.Arrays;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,0,1};

        missingNumber(nums);
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length - 1;

        for (int i = 0; i < length; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }

        if (nums[0] == 0) return nums.length;
        return 0;
    }

    public static int missingNumber2(int[] nums) {
        int length = nums.length;
        int length2 = length + 1;
        boolean[] numExists = new boolean[length2];

        for (int i = 0; i < length; i++) {
            numExists[nums[i]] = true;
        }

        for (int i = 0; i < length2; i++) {
            if (!numExists[i]) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }
}
