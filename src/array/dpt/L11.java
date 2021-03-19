package array.dpt;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 * 1.双指针，包围的面积
 */
public class L11 {
    public int maxArea(int[] nums) {
        if (nums.length == 0)  return 0;

        int area = 0, res = 0;
        int i = 0, j = nums.length - 1; // [i,j]

        while (i < j) {
            area = Math.min(nums[i], nums[j]) * (j - i);
            res = Math.max(res, area);  // update

            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};

        L11 l = new L11();
        var res = l.maxArea(nums);
        System.out.println(res);
    }
}
