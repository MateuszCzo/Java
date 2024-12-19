import java.util.PriorityQueue;

public class Main {
//    You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
//
//We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
//
//Return the largest number of chunks we can make to sort the array.
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{2,0,1}));
    }

//    O(n * log(n))
    public static int maxChunksToSorted(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        int chunks = 0;
        int chunkMax = Integer.MIN_VALUE;
        for (int num : arr) {
            chunkMax = Math.max(chunkMax, num);
            minHeap.remove(num);
            if (minHeap.isEmpty() || chunkMax < minHeap.peek()) {
                chunks++;
                chunkMax = Integer.MIN_VALUE;
            }
        }

        return chunks;
    }
}