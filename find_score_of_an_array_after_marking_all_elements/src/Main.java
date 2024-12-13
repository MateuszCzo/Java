import java.util.PriorityQueue;

public class Main {
//    You are given an array nums consisting of positive integers.
//
//Starting with score = 0, apply the following algorithm:
//
//Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
//Add the value of the chosen integer to score.
//Mark the chosen element and its two adjacent elements if they exist.
//Repeat until all the array elements are marked.
//Return the score you get after applying the above algorithm.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public long findScore(int[] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        boolean[] marked = new boolean[nums.length];
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[]{nums[i], i});
        }

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            if (marked[index]) continue;

            marked[index] = true;
            if (index - 1 >= 0) marked[index - 1] = true;
            if (index + 1 < nums.length) marked[index + 1] = true;
            sum += value;
        }

        return sum;
    }
}