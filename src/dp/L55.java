package dp;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 1. 贪心算法
 * 转化成最大能跳多远
 */
public class L55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0)  return false;

        int farther = 0;
        for (int i=0; i<n-1; i++) {
            farther = Math.max(farther, i+nums[i]);

            // 卡住了
            if (farther <= i)   return false;
        }

        return farther >= n-1;
    }

    public static void main(String[] args) {
        L55 l = new L55();
        var res = l.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(res);
    }
}
