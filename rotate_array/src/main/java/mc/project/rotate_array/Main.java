package mc.project.rotate_array;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = i/100;
        }
        int k = 5_000_000;

        long startTime = System.currentTimeMillis();

        rotate(nums, k);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    private static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
