package mc.project.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        int longest = 0;
        int counter;

        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                counter = 1;
                while (numsSet.contains(++num)) {
                    counter++;
                }
                longest = Math.max(counter, longest);
            }
        }
        return longest;
    }
}
