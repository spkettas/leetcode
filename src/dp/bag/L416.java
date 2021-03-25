package dp.bag;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 1.完成背包问题
 */
public class L416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        int sum = 0, maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
        }

        // 非偶数
        if ((sum&1) == 1)  return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n+1][target + 1];

        // false
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=target; j++) {
                dp[i][j] = false;
            }
        }

        for (int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=target; j++) {
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]]; // &&&
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        //int[] nums = {2,2,3,5};

        L416 l = new L416();
        var res = l.canPartition(nums);
        System.out.println(res);
    }
}
