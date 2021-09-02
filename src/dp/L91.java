package dp;

/**
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * <p>
 * 1.dp
 */
public class L91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 空字符只有一种

        for (int i = 1; i <= n; i++) {
            // 一个字符只有一种情况
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // 两个字符 s[i-2]!='0' s[xx] <= 26
            if (i > 1 && s.charAt(i-2) != '0' &&
                    (10 * (s.charAt(i-2) - '0') + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        L91 l = new L91();
        System.out.println(l.numDecodings("11106"));
    }
}
