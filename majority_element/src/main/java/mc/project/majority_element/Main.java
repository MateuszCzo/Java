package mc.project.majority_element;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,3,2};

        long startTime = System.currentTimeMillis();

        int val2 = majorityElement(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                counter++;
            } else {
                if (counter == 0) {
                    num = nums[i];
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        return num;
    }
}
