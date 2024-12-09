public class Main {
//    An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
//
//You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that
//subarray
// nums[fromi..toi] is special or not.
//
//Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] temp = new int[nums.length];
        boolean[] result = new boolean[queries.length];

        temp[0] = 1;
        int modPrev = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int modCurr = nums[i] % 2;
            temp[i] = (modPrev != modCurr) ? (temp[i - 1] + 1) : 1;
            modPrev = modCurr;
        }

        for (int i = 0; i < queries.length; i++) {
            int length = queries[i][1] - queries[i][0] + 1;
            result[i] = temp[queries[i][1]] >= length;
        }

        return result;
    }
}