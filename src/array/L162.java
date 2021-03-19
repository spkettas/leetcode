package array;


/**
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 1. nums[i]>nums[i+1]
 */
public class L162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;

        for (int i=0; i<nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }

        return nums.length -1;  // &&& 一个元素的情况
    }

    public static void main(String[] args) {
        L162 l = new L162();
        var res = l.findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(res);
    }
}
