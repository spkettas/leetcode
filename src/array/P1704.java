package array;

/**
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 * 1. 异或    res = res ^ (x ^ x)
 */
public class P1704 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 0)   return -1;

        int res = 0;
        for (int i=1; i<=n; ++i) {
            res = res ^ i ^ nums[i-1];  // i数字 nums[i-1]实际数字，重复数字会被清零
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};

        P1704 p = new P1704();
        var res = p.missingNumber(nums);
        System.out.println(res);
    }
}
