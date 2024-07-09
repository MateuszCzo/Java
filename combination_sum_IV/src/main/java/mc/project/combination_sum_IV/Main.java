package mc.project.combination_sum_IV;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        combinationSum4(nums, 4);
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        for (int key = 1; key <= target; key++) {
            int total = 0;
            for (int num : nums) {
                total += cache.getOrDefault(key - num, 0);
            }
            cache.put(key, total);
        }

        return cache.get(target);
    }
}
