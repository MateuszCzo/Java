import java.util.PriorityQueue;

public class Main {
//    You are given an integer array nums, an integer k, and an integer multiplier.
//
//You need to perform k operations on nums. In each operation:
//
//Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
//Replace the selected minimum value x with x * multiplier.
//Return an integer array denoting the final state of nums after performing all k operations.
    public static void main(String[] args) {
        System.out.println(getFinalState(new int[]{2,1,3,5,6}, 5, 2));
    }

    // O(n + log(n) * k)
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        // index, value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int diff = a[1] - b[1];
            if (diff == 0) return a[0] - b[0];
            return diff;
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[]{i, nums[i]});
        }

        for (int i = 0; i < k; i++) {
            int[] minValue = minHeap.poll();
            int index = minValue[0];
            int value = minValue[1];
            nums[index] *= multiplier;
            minHeap.add(new int[]{index, value * multiplier});
        }

        return nums;
    }
}