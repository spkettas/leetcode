package dp;

/**
 * 62. 不同路径I
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 2      3*2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 1. 标准简单型
 * dp[i][j] = dp[i-1][j] + dp[i][j-1];
 */
public class L62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            dp[i][0] = 1;
        }

        for (int i=0; i<n; i++) {
            dp[0][i] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        L62 l = new L62();
        var res = l.uniquePaths(7, 3);
        System.out.println(res);
    }
}
