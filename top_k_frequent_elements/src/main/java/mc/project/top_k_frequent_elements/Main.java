package mc.project.top_k_frequent_elements;

import com.sun.source.tree.Tree;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        topKFrequent(nums, k);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] returnArray = new int[k];
        for (int i = 0; i < k; i++) {
            returnArray[i] = priorityQueue.poll().getKey();
        }

        return returnArray;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        Map.Entry<Integer, Integer>[] entries = numsMap.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(entries, Comparator.comparing(Map.Entry::getValue));

        int[] returnArray = new int[k];
        for (int i = 0; i < k; i++) {
            returnArray[i] = entries[entries.length - 1 - i].getKey();
        } 

        return returnArray;
    }
}
