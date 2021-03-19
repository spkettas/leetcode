package basic.bin;

/**
 * x的平方根
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去
 *
 * 1. 二分查找，除2的乘积
 */
public class L69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int left = 0, right = x;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            long val = (long) mid * mid;  // &&& long

            if (val <= x) {
                left = mid + 1;
                res = mid;
            } else if (val > x) {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L69 l = new L69();

        var res = l.mySqrt(2);
        System.out.println(res);
    }
}
