import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
//    You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:
//
//Choose the pile with the maximum number of gifts.
//If there is more than one pile with the maximum number of gifts, choose any.
//Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
//Return the number of gifts remaining after k seconds.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        while(k-- > 0) {
            int curr = maxHeap.poll();
            maxHeap.add((int)Math.sqrt(curr));
        }
        long result = 0;
        while(!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }
        return result;
    }
}