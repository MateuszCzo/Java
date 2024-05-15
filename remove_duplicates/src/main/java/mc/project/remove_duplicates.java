package mc.project;

public class remove_duplicates {
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = i/100;
        }

        long startTime = System.currentTimeMillis();

        int val2 = removeDuplicates(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int i=1;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
