package mc.project.contains_duplicates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            nums[i] = (int)(1 + (Math.random() * 999_999_999));
        }

        long startTime = System.currentTimeMillis();

        boolean val2 = containsDuplicate2(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int num : nums) {
            if (numsMap.containsKey(num)) {
                return true;
            }
            numsMap.put(num, 1);
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            if (!numsSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
