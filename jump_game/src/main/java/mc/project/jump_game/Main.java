package mc.project.jump_game;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = (int)(1 + (Math.random() * 99));
        }

        long startTime = System.currentTimeMillis();

        boolean val = canJump2(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val);
    }

    public static boolean canJump(int[] nums) {
        int availableJumps = nums[0];
        int index = 0;

        while (availableJumps >= 0) {
            if (index == nums.length - 1) {
                return true;
            }
            if (nums[index] > availableJumps) {
                availableJumps = nums[index];
            }
            index++;
            availableJumps--;
        }
        return false;
    }

    public static boolean canJump2(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
