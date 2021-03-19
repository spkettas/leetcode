package basic.calc;

/**
 * 进制转换
 *
 * 1.取模
 */
public class Scale {
    public static String solve (int M, int N) {
        if (M == 0) return "0";

        String base = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();

        boolean f = false;

        // 负数情形
        if (M < 0) {
            f = true;
            M = -M;
        }

        while (M != 0) {
            sb.append(base.charAt(M % N));
            M = M / N;
        }

        if (f) sb.append("-");

        // &&& 反转
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var res = solve(100, 2);
        System.out.println(res);
    }
}
