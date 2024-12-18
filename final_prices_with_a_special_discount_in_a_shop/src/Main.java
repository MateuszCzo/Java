import java.util.Stack;

public class Main {
//    You are given an integer array prices where prices[i] is the price of the ith item in a shop.
//
//There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
//
//Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = prices[i];
            } else {
                result[i] = prices[i] - prices[stack.peek()];
            }
            stack.push(i);
        }

        return result;
    }
}