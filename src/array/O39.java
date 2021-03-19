package array;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 1. 摩尔投票法
 * a. 一定存在题型
 * b. 不存在题型，判断众数出现的次数
 */
public class O39 {
    public int majorityElement(int[] nums) {
        int vote = 0, x = 0;

        for (int num : nums) {
            if (vote == 0)  x = num;
            vote += (x == num) ? 1 : -1;    // 特别简洁
        }

        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        O39 o = new O39();
        var res = o.majorityElement(nums);
        System.out.println(res);
    }
}
