package com.github.jxiu.doing;

import java.util.Arrays;

/**
 *  188 买卖股票的最佳时机 IV (hard)
 *  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimeToBuyAndSellStockIV {

    //TODO 复习
    /**
     *
     * @param k 最多完成的股票次数
     * @param prices 股票当前的价值
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if (days < 2){
            return 0;
        }
        if (k * 2 >= days) return maxProfitUnlimited(prices);

        int[] buy = new int[k +1];// 某天买入时候最大收益
        int[] sell = new int[k +1];// 某天卖出时候最大收益
        for (int i = 0; i < buy.length; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        System.out.println("k = " + k + ", prices = " + Arrays.toString(prices));
        for (int i = 0; i < days; i++) {
            for (int j = 1; j <= k ; j++) {
                // 截止某天买入1...k次花费的钱，
                // 第i天买入j次的花费 = 卖 j-1次的花费 + 新一次的花费
                // 第i天卖出j次的利润 = 买入j次的花费 + 新的一次利润
                buy[j] = Integer.max(buy[j],sell[j-1] - prices[i]);
                sell[j] = Integer.max(sell[j], buy[j] + prices[i]);
                System.out.printf("day: %d, %d 次：累计花费：%d,累计最大利润%d\n",i,j,buy[j],sell[j]);
            }
            System.out.println(Arrays.toString(buy));
            System.out.println(Arrays.toString(sell));
        }
        return sell[k];
    }

    // 贪心算法, 隔天就卖
    private int maxProfitUnlimited(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                maxProfit = maxProfit + (prices[i] - prices[i-1]);
            }
        }
        return maxProfit;
    }
}
