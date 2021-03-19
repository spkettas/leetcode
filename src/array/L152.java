package array;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6
 *
 * 1.区分正数/负数两种情况，如有负数则交换最大值
 */
public class L152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            // swap
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax * nums[i], nums[i]);   // 累积量
            imin = Math.min(imin * nums[i], nums[i]);

            // 记录每次最大值
            max = Math.max(max, imax);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};

        L152 l = new L152();
        var res = l.maxProduct(nums);
        System.out.println(res);
    }
}
