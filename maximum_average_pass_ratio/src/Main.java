import java.util.PriorityQueue;

public class Main {
//    There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
//
//You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
//
//The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
//
//Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // index, average difference
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < classes.length; i++) {
            addNextAvg(classes, i, maxHeap);
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] bestChoice = maxHeap.poll();
            int classIndex = (int)bestChoice[0];
            classes[classIndex][0]++;
            classes[classIndex][1]++;
            addNextAvg(classes, classIndex, maxHeap);
        }

        double result = 0;
        for (int[] currClass : classes) {
            result += (double) currClass[0] / currClass[1];
        }

        return result / classes.length;
    }

    private static void addNextAvg(int[][] classes, int i, PriorityQueue<double[]> maxHeap) {
        int pass = classes[i][0];
        int total = classes[i][1];
        double currAvg = (double) pass / total;
        double nextAvg = (double) (pass + 1) / (total + 1);
        double diffAvg = nextAvg - currAvg;
        maxHeap.add(new double[]{i, diffAvg});
    }
}