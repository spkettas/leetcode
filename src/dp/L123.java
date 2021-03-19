package dp;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 1. dp
 * 第i天，无股票，交易次数最多k次，获得的最多利润数
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 * dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
 * dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
 * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
 * dp[i][1][1] = max(dp[i-1][1][1], -prices[i])     dp[i-1][0][0]=0
 *
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/123-mai-mai-gu-piao-de-zui-jia-shi-ji-ii-zfh9/
 */
public class L123 {
    public int maxProfit(int[] prices) {
        // 1-2 有股票，无股票
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;

        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }

        return dp_i20;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        L123 l = new L123();
        var res = l.maxProfit(prices);
        System.out.println(res);
    }
}
