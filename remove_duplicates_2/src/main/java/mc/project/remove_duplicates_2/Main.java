package mc.project.remove_duplicates_2;

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = i/100;
        }

        long startTime = System.currentTimeMillis();

        int val2 = removeDuplicates2(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;;
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index] != nums[i] || nums[index - 1] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;;
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index-1] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
