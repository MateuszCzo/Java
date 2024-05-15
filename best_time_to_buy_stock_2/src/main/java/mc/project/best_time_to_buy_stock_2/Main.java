package mc.project.best_time_to_buy_stock_2;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = (int)(1 + (Math.random() * 99));
        }

        long startTime = System.currentTimeMillis();

        int val2 = maxProfit3(nums);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length < 2) return profit;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        if (prices.length < 2) return profit;
        int j = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[j] < prices[i] && (i + 1 >= prices.length || prices[i] > prices[i + 1])) {
                profit += prices[i] - prices[j];
                j = i + 1;
            } else {
                j = i;
            }
        }
        return profit;
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length, l = 0, r = 0, ans = 0;
        while(r < n) {
            if(prices[r] < prices[l]) l = r;
            ans += prices[r] - prices[l];
            l = r++;
        }
        return ans;
    }
}
