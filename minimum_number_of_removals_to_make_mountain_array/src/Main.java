import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
//  You may recall that an array arr is a mountain array if and only if:
//
//  arr.length >= 3
//  There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
//  arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//  arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//  Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.

    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        List<Integer> lisLR = longestIncreasingSubsequenceForIndex(nums);
        reverseArray(nums);
        List<Integer> lisRL = longestIncreasingSubsequenceForIndex(nums);
        Collections.reverse(lisRL);

        int maxMountainSize = 0;
        for (int i = 0; i < n; i++) {
            if (lisLR.get(i) > 1 && lisRL.get(i) > 1) {
                maxMountainSize = Math.max(maxMountainSize, lisLR.get(i) + lisRL.get(i) - 1);
            }
        }
        return n - maxMountainSize;
    }

    private static List<Integer> longestIncreasingSubsequenceForIndex(int[] nums) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 1));

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            int index = Collections.binarySearch(lis, num);
            if (index < 0) index = -index - 1;
            if (index >= lis.size()) lis.add(num);
            else lis.set(index, num);
            result.set(i, lis.size());
        }
        return result;
    }

    private static void reverseArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}