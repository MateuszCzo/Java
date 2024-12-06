import java.util.HashSet;
import java.util.Set;

public class Main {
//    You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:
//
//The chosen integers have to be in the range [1, n].
//Each integer can be chosen at most once.
//The chosen integers should not be in the array banned.
//The sum of the chosen integers should not exceed maxSum.
//Return the maximum number of integers you can choose following the mentioned rules.
    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{11}, 7, 50));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();

        for (int num : banned) {
            if (num <= n) {
                bannedSet.add(num);
            }
        }

        int currentSum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            currentSum += i;
            if (currentSum >= maxSum) {
                return count;
            }
            count++;
        }

        return count;
    }
}