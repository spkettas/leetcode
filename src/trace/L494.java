package trace;

import java.util.HashMap;
import java.util.Map;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3
 *
 * 1. 回溯法
 * 2. 回溯法; 消除重叠子问题
 * 3. dp 背包问题; S(A) = (target + sum)/2
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
 * 4. dp 状态压缩
 * dp[j] = dp[j] + dp[j-nums[i-1]]
 *
 */
public class L494 {
    private int res;    // 结果
    private Map<String, Integer> memo; // 备忘录

    /**
     * 1.回溯法，选择+ -
     */
    public void backtrace(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0)
                res++;
            return;
        }

        // +
        rest -= nums[i];
        backtrace(nums, i + 1, rest);
        rest += nums[i];

        // -
        rest += nums[i];
        backtrace(nums, i + 1, rest);
        rest -= nums[i];
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        res = 0;
        backtrace(nums, 0, S); // &&& start
        return res;
    }

    public int dfs(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }

            return 0;
        }

        String key = String.format("%d-%d", i, rest);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = dfs(nums, i + 1, rest - nums[i]) + dfs(nums, i + 1, rest + nums[i]);
        memo.put(key, result);
        return result;
    }

    /**
     * 2. 带memo的优化
     */
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums.length == 0) return 0;

        memo = new HashMap<>();
        return dfs(nums, 0, S);
    }

    public int findSubset(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public int findSubset1(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
        }

        return dp[target];
    }

    /**
     * 3. dp背包问题
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;

        return findSubset(nums, (S + sum) / 2);
    }

    /**
     * 4. dp状态压缩
     * a. 两层循环，内层逆序
     * b.
     */
    public int findTargetSumWays3(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;

        return findSubset1(nums, (S + sum) / 2);
    }

    public static void main(String[] args) {
        L494 l = new L494();
        var res = l.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(res);

        res = l.findTargetSumWays1(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(res);

        res = l.findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(res);

        res = l.findTargetSumWays3(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(res);
    }
}
