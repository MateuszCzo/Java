package mc.project.longest_increasing_subsequence;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};

        int val = lengthOfLIS(nums);
        System.out.println(val);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] subArray = new int[nums.length];
        int subIndex = 0;
        int temp;

        subArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > subArray[subIndex]) {
                subArray[++subIndex] = nums[i];
                continue;
            }
            temp = subIndex;
            while (temp >= 0 && subArray[temp] >= nums[i]) temp--;
            subArray[temp + 1] = nums[i];
        }

        return subIndex + 1;
    }
}
