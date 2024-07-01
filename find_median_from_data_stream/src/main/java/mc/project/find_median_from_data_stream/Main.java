package mc.project.find_median_from_data_stream;

import java.util.PriorityQueue;

public class Main {
    static class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            max = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.add(num);

            if (!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek()) {
                max.add(min.poll());
                min.add(max.poll());
            }
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
            if (min.size() > max.size() + 1) {
                min.add(max.poll());
            }
        }

        public double findMedian() {
            if (!min.isEmpty() && min.size() > max.size()) {
                return min.peek();
            } else if (!max.isEmpty() && max.size() > min.size()) {
                return max.peek();
            } else if (!min.isEmpty()){
                return (min.peek() + max.peek()) / 2d;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(12);
        medianFinder.addNum(10);
        medianFinder.addNum(13);
        medianFinder.addNum(11);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }

}
