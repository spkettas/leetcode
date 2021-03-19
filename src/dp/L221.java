package dp;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 1.dp
 * dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
 */
public class L221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n]; // &&& [m][n]
        int maxSlide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '1') continue;  // &&& 1

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }

                maxSlide = Math.max(maxSlide, dp[i][j]);
            }
        }

        return maxSlide * maxSlide;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        L221 l = new L221();
        var res = l.maximalSquare(matrix);
        System.out.println(res);
    }
}
