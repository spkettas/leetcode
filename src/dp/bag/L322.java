package dp.bag;

import java.util.Arrays;

/**
 * 零钱兑换I: 最少硬币数量
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * input: [1,2,5] 11
 * output: 3
 * 11 = 5 + 5 + 1
 *
 * 1. 子问题+1
 * dp[i] = min(dp[i], dp[i-coin]+1)
 */
public class L322 {
    // I: 自底向上
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        // 选择状态
        for (int i=0; i<dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        L322 l = new L322();

        int res = l.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res); // 3
    }
}
