package com.github.jxiu;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 474. Ones and Zeroes（medium）
 * <p>
 *     背包问题，每个dp数组代表在某个代价下能带来的价值，数组最后一个元素代表最终的结果
 *     <p>
 *         没有优化：状态转移 = 每件新的物品加入后（从最小的代价 到 最大代价）对价值的影响
 *         优化后：状态转移 = 每件新的物品加入后（从最大的代价 到 最小代价）对价值的影响（因为可能影响后续结果，需要反向遍历）
 *     </p>
 * </p>
 */
public class OnesAndZeroes {

    /**
     * 有两个背包的0 1背包问题
     * @param strs
     * @param m 0的个数
     * @param n 1的个数
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str: strs){
            Map<Integer, Long> ccm = str.chars().boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            int count0 = ccm.getOrDefault((int)'0',0L).intValue();
            int count1 = ccm.getOrDefault((int)'1',0L).intValue();
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1 ; j--) {
                    // 价值是1 ，花费count0个0,count1个1
                    dp[i][j] = Integer.max(dp[i][j], dp[i-count0][j-count1] +1);
                }
            }
        }
        return dp[m][n];
    }
}
