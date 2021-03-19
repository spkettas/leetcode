package array.dpt;


import util.MyPrint;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * o(n)，不能使用除法
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 1. 左右两个乘积数组
 */
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[]{};

        int[] left = new int[n];    // 存放左侧乘积
        int[] right = new int[n];    // 存放右侧乘积
        left[0] = right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // &&& >=
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];  // i+1
        }

        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    public static void main(String[] args) {
        L238 l = new L238();
        var res = l.productExceptSelf(new int[]{1, 2, 3, 4});
        MyPrint.show(res);
    }
}
