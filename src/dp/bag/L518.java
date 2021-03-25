package dp.bag;

/**
 * 零钱兑换II，凑成总金额所需硬币组合数
 * input: 5  [1,2,5]
 * output: 4
 * 5 = 5
 * 5 = 2+2+1
 * 5 = 2+1+1+1
 * 5 = 1+1+1+1+1
 *
 * 1.动态规划，完全背包问题
 * dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]  i个硬币j的金额
 */
public class L518 {
    // 1.标准解法
    public int change(int amount, int[] coins) {
        if (amount == 0)  return 1;
        if (coins != null && coins.length == 0 && amount > 0) {
            return 0;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // false
        for (int i=0; i<=amount; i++) {
            dp[0][i] = 0;
        }

        // true
        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        // 状态转移方程
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=amount; j++) {
                if (j - coins[i-1] >= 0) {  // &&& >=
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }

    /**
     * 2.状态压缩
     * dp与 dp[i][x] dp[i-1][x] 有关
      */
    public int change1(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (amount > 0 && coins != null && coins.length == 0) {
            return 0;
        }

        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // base case

        // 状态
        for (int i=0; i<n; i++) {
            for (int j=1; j<=amount; j++) {
                if (j - coins[i] >= 0)  // &&& >=
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        L518 l = new L518();
        var res = l.change(5, new int[]{1, 2, 5});
        System.out.println(res);

        res = l.change1(5, new int[]{1, 2, 5});
        System.out.println(res);
    }
}
