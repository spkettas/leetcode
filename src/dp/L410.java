package dp;

/**
 * 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 1. dp
 * f[i][j] = min(f[k][j-1], sub[k+1,i])
 *
 * 2. 二分查找
 * https://leetcode-cn.com/problems/split-array-largest-sum/solution/bai-hua-er-fen-cha-zhao-by-xiao-yan-gou/
 */
public class L410 {
    public int splitArray(int[] nums, int m) {

    }

    public static void main(String[] args) {
        L410 l = new L410();

    }
}
