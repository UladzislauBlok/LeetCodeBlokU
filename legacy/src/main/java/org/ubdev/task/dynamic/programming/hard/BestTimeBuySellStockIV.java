package org.ubdev.task.dynamic.programming.hard;

class BestTimeBuySellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        for (int i = 0; i < k; i++) {
            int position = -prices[0];
            int profit = 0;
            for (int j = 1; j < prices.length; j++) {
                position = Math.max(position, dp[j] - prices[j]);
                profit = Math.max(profit, position + prices[j]);
                dp[j] = profit;
            }
        }
        return dp[prices.length - 1];
    }
}
