import java.util.HashMap;
import java.util.Map;

public class Main {
//    You are given a 0-indexed integer array nums of length n.
//
//You can perform the following operation as many times as you want:
//
//Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
//Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
//
//A strictly increasing array is an array whose each element is strictly greater than its preceding element.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean primeSubOperation(int[] nums) {
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - prev;
            if (diff <= 0) {
                return false;
            }
            prev = nums[i] - getMaxPrimary(diff - 1);
        }

        return true;
    }

    private static final Map<Integer, Boolean> cache = new HashMap<>();

    private static int getMaxPrimary(int max) {
        for (int i = max; i > 1; i--) {
            if (isPrimary(i)) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isPrimary(int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        if (num < 2) {
            cache.put(num, false);
            return false;
        }
        boolean isPrimary = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                isPrimary = false;
                break;
            }
        }
        cache.put(num, isPrimary);
        return isPrimary;
    }
}