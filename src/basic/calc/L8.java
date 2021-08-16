package basic.calc;

/**
 * 1. 二进制个数
 * 2. 2的幂
 */
public class L8 {
    // 1.2的幂
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n-1)) == 0;
    }

    // 2.2的个数
    public int numof2(int n) {
        int cnt = 0;

        while (n != 0) {
            ++cnt;
            n = n & (n-1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        L8 l = new L8();
        System.out.println(l.numof2(8));
    }
}
