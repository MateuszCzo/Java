package mc.project.three_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            searchForTwoSum(nums, i, result);
        }
        return result;
    }

    protected void searchForTwoSum(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1, right = nums.length - 1;

        while (left < right) {
            int threeSum = nums[i] + nums[left] + nums[right];

            if (threeSum > 0) {
                right--;
            } else if (threeSum < 0) {
                left++;
            } else {
                result.add(List.of(nums[i], nums[left], nums[right]));
                left = updateLeftPointer(nums, ++left, right);
            }
        }
    }

    protected int updateLeftPointer(int[] nums, int left, int right) {
        while(nums[left] == nums[left - 1] && left < right) {
            left++;
        }
        return left;
    }
}
