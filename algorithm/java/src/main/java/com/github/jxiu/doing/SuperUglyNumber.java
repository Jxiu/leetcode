package com.github.jxiu.doing;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 313. 超级丑数
 */
public class SuperUglyNumber {

    // TODO 动态规划

    /**
     * 最小堆
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        minQueue.add(1);
        while (n-- > 0){
            int x = minQueue.poll(); // 取出最小数
            if (n == 0) return x;
            for (int i : primes){
                if ( i < Integer.MAX_VALUE/x){
                    minQueue.add(i * x); // 所有质数*最小数
                }
                System.out.println(minQueue);
                if (x % i == 0){ // 当前最小值因数包含最小的质数，跳过减少次数
                    break;
                }
            }
            System.out.println(n + "次：" + minQueue);

        }
        return -1;
    }
}
