package array;

import util.MyPrint;

/**
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 *
 * 输入: [2,3]
 * 输出: [1,4]
 *
 * 1.异或
 * 分离num1和num2
 *
 * https://leetcode-cn.com/problems/missing-two-lcci/solution/shuang-bai-ji-bai-de-fen-zu-yi-huo-jie-f-mb8g/
 */
public class P1719 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[]{};

        int ans = 0;
        int N = n + 2;  // &&& 2个数

        // 1.消失的第一个数
        for (int num : nums) {
            ans ^= num;
        }

        for (int i=1; i<=N; ++i) {
            ans ^= i;
        }

        int j;

        // 2.分组
        for (j = 0; j<32; ++j) {
            if ((ans >> j & 0x1) == 1)  break;
        }

        int num1 = 0, num2 = 0;

        // 3.拆原数
        for (int num : nums) {
            if ((num >> j & 0x1) == 1) num1 ^= num;
            else num2 ^= num;
        }

        // 4.拆索引
        for (int i=1; i<=N; ++i) {
            if ((i >> j & 0x1) == 1)  num1 ^= i;
            else num2 ^= i;
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};

        P1719 p = new P1719();
        var res = p.missingTwo(nums);
        MyPrint.show(res);
    }
}
