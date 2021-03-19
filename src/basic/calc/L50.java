package basic.calc;

/**
 * x的n次方
 *
 * 1. 暴力法
 * 2. 递归法 - 快速幂；考虑正负数
 */
public class L50 {
    // 1. 暴力法 O(N)
    public int myPow1(int x, int n) {
        int ret = 1;

        for (int i=0; i<n; i++) {
            ret *= x;
        }

        return ret;
    }

    // 2. 递归法 o(lgn)
    public int myPow2(int x, int n) {
        if (n == 0)  return 1;

        int val = myPow2(x, n / 2);
        if ((n&1) == 1) {
            return val * val * x;
        }

        return val * val;
    }

    public double quickPow(double x, int n) {
        if (n == 0)  return 1.0;

        double y = quickPow(x, n / 2);
        return (n & 1) == 1 ? x * y * y : y * y;
    }

    // 3. 快速幂
    public double myPow(double x, int n) {
        if (n == 0)  return 1.0;

        return n >= 0 ? quickPow(x, n) : 1.0 / quickPow(x, -n);
    }

    public static void main(String[] args) {
        L50 l = new L50();
        var res = l.myPow(2.0, 10);
        System.out.println(res);

        res = l.myPow1(5, 10);
        System.out.println(res);
    }
}
