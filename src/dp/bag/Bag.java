package dp.bag;


import java.util.Arrays;

/**
 * 0-1 背包问题，最多能装价值多少
 *
 * 1. 经典框架
 * dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
 * i个物品，容量为w时，最多可以装多少
 */
public class Bag {
    /**
     * 背包问题
     * @param N     物品个数
     * @param W     背包载重量
     * @param wt    重量列表
     * @param val   价值列表
     */
    public int fillBag(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N+1][W+1];

        // init
        for (int i=0; i<N+1; i++) {
            for (int j=0; j<W+1; j++) {
               dp[i][j] = 0;
            }
        }

        // i=1 w=1
        for (int i=1; i<=N; i++) {
            for (int w=1; w<=W; w++) {
                if (w - wt[i-1] < 0) {  // 背包容量不够
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // &&& val[i-1]
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        Bag k = new Bag();
        var res = k.fillBag(3, 4, wt, val);
        System.out.println(res);
    }
}
