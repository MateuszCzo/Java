import java.util.Arrays;

public class Main {
//    You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
//
//Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
//Remove the last element from the current array nums.
//Return an array answer, where answer[i] is the answer to the ith query.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] result = new int[nums.length];
        int maximizedNumber = (1 << maximumBit) - 1;
        result[nums.length - 1] = nums[0];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] ^ nums[nums.length - 1 - i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] ^ maximizedNumber;
        }
        return result;
    }
}