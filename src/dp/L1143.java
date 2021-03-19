package dp;


/**
 * 1.最长公共子序列
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3
 *
 * 2.最长连续公共序列值
 *
 * 1. dp
 * dp[i][j] = dp[i-1][j-1] + 1
 *          = max(dp[i][j-1], dp[i-1][j])
 *
 * [i-1,j-1] [i-1,j]
 * [i,j-1]  <i,j>
 */
public class L1143 {
    // 1.最长公共序列长度
    public int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=n; i++) dp[0][i] = 0;
        for (int i=0; i<=m; i++) dp[i][0] = 0;

        // 正序遍历
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // &&& i-1
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 2.最长连续公共序列值，只处理连续情况
     */
    public String longestCommonSubsequence1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "-1";
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<n; i++) dp[0][i] = 0;
        for (int i=0; i<m; i++) dp[i][0] = 0;

        int maxLen = 0, end = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                    if (dp[i][j] >= maxLen) {
                        maxLen = dp[i][j];
                        end = i - 1;
                    }
                } else {
                    //dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = 0;
                }
            }
        }

        if (maxLen == 0)  return "-1";
        return s1.substring(end - maxLen + 1, end + 1);
    }

    public static void main(String[] args) {
        L1143 l = new L1143();
        var res = l.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);

        var com = l.longestCommonSubsequence1("1AB2345CD", "12345EF");
        System.out.println(com);
    }
}
