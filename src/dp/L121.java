package dp;


/**
 * 121. 买卖股票的最佳时机
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 1.一次遍历，取最低位，利润大的位
 */
public class L121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int minPrice = Integer.MAX_VALUE;  // &&& MAX
        int profit = 0;

        for (int i=0; i<n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        //int[] nums = {7, 1, 5, 3, 6, 4};
        int[] nums = {1, 4, 2};

        L121 l = new L121();
        var res = l.maxProfit(nums);
        System.out.println(res);
    }
}