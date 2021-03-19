package dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
 *
 * 1. dp
 * dp[i] = max(dp[i], dp[j] + 1)   数组i最长序列长度是x
 */
public class L300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];  // &&& n
        Arrays.fill(dp, 1);  // &&& 1

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {  // &&& j<1
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;

        // 求最大
        for (int i=0; i<n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        L300 l = new L300();
        var res = l.lengthOfLIS(nums);
        System.out.println(res);
    }
}
