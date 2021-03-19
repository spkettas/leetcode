package mind;


import trace.L47;

import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 * 输入: 3
 * 输出: [8,1,10]
 *
 * 1.数学公式
 * (rand_X() - 1) × Y + rand_Y() -> 等概率的生成[1, X * Y]范围的随机数
 * rand_N() % 10 + 1  [1,10]的范围
 *
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/
 */
public class L470 {
    // 1 - 7
    private int rand7() {
        Random rd = new Random();
        return 1 + Math.abs(rd.nextInt() % 7);
    }

    public int rand10() {
        int idx = 0;

        do {
            int row = rand7();
            int col = rand7();
            idx = row + (col - 1) * 7;  // [1,49]
        } while (idx > 40);

        return 1 + (idx - 1) % 10;
    }

    public static void main(String[] args) {
        L470 l = new L470();
        var res = l.rand10();
        System.out.println(res);
    }
}
