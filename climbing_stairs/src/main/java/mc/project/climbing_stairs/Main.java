package mc.project.climbing_stairs;
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Main {
    public static void main(String[] args) {
        int n = 4;

        int val = climbStairs(n);
        System.out.println(val);
    }

    public static int climbStairs(int n) {
        int prevStep = 0;
        int prevStep2 = 1;
        int temp;

        for (int i = 1; i < n; i++) {
            temp = prevStep2;
            prevStep2 += prevStep;
            prevStep = temp;
        }
        return prevStep + prevStep2;
    }
}
