package dp;


/**
 * 122. 买卖股票的最佳时机 II
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 1. dp
 * ans += Math.max(0, price[i] - price[i-1])
 */
public class L122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int ans = 0;

        for (int i=1; i<n; i++) {
            // &&& 0
            ans += Math.max(0, prices[i] - prices[i - 1]);  // >0
        }

        return ans;
    }

    public static void main(String[] args) {
        L122 l = new L122();
        var res = l.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }
}
