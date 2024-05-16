package mc.project.jump_game_2;
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,1,1,4};

        long startTime = System.currentTimeMillis();

        int val = jump(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val);
    }

    public static int jump(int[] nums) {
        int jumps = 0;
        int currentMaxJumpingNumber = 0;
        int currentJumpNumber = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (currentMaxJumpingNumber < nums[i] + i) {
                currentMaxJumpingNumber = nums[i] + i;
            }
            if (currentJumpNumber == i) {
                currentJumpNumber = currentMaxJumpingNumber;
                jumps++;
            }
        }

        return jumps;
    }

    public static int jumpAndCheck(int[] nums) throws Exception {
        int jumps = 0;
        int currentMaxJumpingNumber = 0;
        int currentJumpNumber = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (currentMaxJumpingNumber < nums[i] + i) {
                currentMaxJumpingNumber = nums[i] + i;
            }
            if (currentJumpNumber == i) {
                currentJumpNumber = currentMaxJumpingNumber;
                jumps++;
            }
            if (i >= currentMaxJumpingNumber) {
                throw new Exception("Can not jump");
            }
        }

        return jumps;
    }
}
