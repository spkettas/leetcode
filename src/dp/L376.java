package dp;


/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 输入: [1,7,4,9,2,5]  +-+-+
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 1. dp 分为上升序列、下降序列
 * down[i] = Math.max(down[i-1], up[i-1] + 1);
 */
public class L376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;

        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;    // &&& =1

        for (int i=1; i<n; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = Math.max(up[i-1], down[i-1] + 1);   // &&& down +1
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                up[i] = up[i-1];
                down[i] = Math.max(up[i-1] + 1, down[i-1]);
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[n-1], down[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,17,5,10,13,15,10,5,16,8};

        L376 l = new L376();
        var res = l.wiggleMaxLength(nums);
        System.out.println(res);
    }
}
