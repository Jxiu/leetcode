package com.github.jxiu.doing;

import java.util.Stack;

import static java.lang.Integer.max;

/**
 * 121. 买卖股票的最佳时机(easy)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // 亏的最少的
        int max = Integer.MIN_VALUE,
                sell = 0;// 赚的最多的
        for (int i = 0; i < prices.length; i++) {
            max = max(max, -prices[i]); //
            sell = max(sell, max + prices[i]);
        }
        return sell;
    }
}
