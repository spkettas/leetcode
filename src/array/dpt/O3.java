package array.dpt;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 1.查找数组中重复数字； - Set去重
 * 2.去重 - 双指针
 * 移除数组中重复数字
 * 链表去重
 *
 */
public class O3 {
    // 1.查找数组重复数字 - set
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0)  return -1;

        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 8, 9, 9, 10};

        O3 o = new O3();
        var res = o.findRepeatNumber(nums);
        System.out.println(res);
    }
}
