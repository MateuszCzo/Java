package mc.project.coin_change;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
public class Main {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        int coinsAmount = coinChange2(coins, amount);
        System.out.println(coinsAmount);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int coinsLastIndex = coins.length - 1;
        int coinsAmount = 0;

        for (int i = coinsLastIndex; i >= 0; i--) {
            coinsAmount += amount / coins[i];
            amount %= coins[i];
        }

        if (amount > 0) return -1;

        return coinsAmount;
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }

        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }
}
