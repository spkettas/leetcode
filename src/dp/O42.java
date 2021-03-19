package dp;

/**
 * 连续子数组最大和
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * 1. dp
 * dp[i] = dp[i-1] + nums[i]
 */
public class O42 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i=1; i<n; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int res = Integer.MIN_VALUE;

        // max
        for (int i=0; i<n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        O42 l = new O42();
        var res = l.maxSubArray(nums);
        System.out.println(res);
    }
}
