package mc.project.find_minimum_in_rotated_sorted_array;
/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,2};

        int min = findMin(nums);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int indexStart = 0, indexEnd = nums.length - 1;
        int middleIndex;

        while (indexStart <= indexEnd) {
            middleIndex = (indexStart + indexEnd) / 2;

            if (nums[indexStart] <= nums[middleIndex]) {
                if (nums[indexStart] <= nums[indexEnd]) {
                    return nums[indexStart];
                } else {
                    indexStart = middleIndex + 1;
                }
            } else {
                indexStart++;
                indexEnd = middleIndex;
            }
        }

        return nums[indexStart];
    }
}
