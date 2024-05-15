package mc.project.remove_element;

import java.sql.Array;

public class Main {
    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = (int)(1 + (Math.random() * 9));
        }
        int val = 3;

        long startTime = System.currentTimeMillis();

        int val2 = removeElement(nums, val);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int k = nums.length - 1;

        while (i <= k) {
            if (nums[i] == val && nums[k] != val) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
                k--;
            }
            if (nums[i] != val) i++;
            if (nums[k] == val) k--;
        }

        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
