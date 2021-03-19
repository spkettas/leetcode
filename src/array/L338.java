package array;

import basic.bin.L33;
import util.MyPrint;

/**
 * 比特位计算
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
 *
 * 输入: 2
 * 输出: [0,1,1]      0-N内所有数bit
 *
 * 1.与O题目一致，实际上是求1的个数
 */
public class L338 {
    public int countOne(int n) {
        int cnt = 0;

        // java无无符号数，改成!=0
        while (n > 0) {
            cnt++;
            n = n&(n-1);
        }

        return cnt;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i=0; i<=num; i++) {
            res[i] = countOne(i);
        }

        return res;
    }

    public static void main(String[] args) {
        L338 l = new L338();
        var res = l.countBits(100);
        MyPrint.show(res);
    }
}
