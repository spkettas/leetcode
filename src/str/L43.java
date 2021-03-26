package str;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 1. 逆向乘法
 */
public class L43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        int m = s1.length, n = s2.length;
        int[] res = new int[m + n];   // &&& m+n

        for (int i=m-1; i>=0; i--) {
            int x = s1[i] - '0';
            for (int j=n-1; j>=0; j--) {
                int y = s2[j] - '0';

                res[i+j+1] += x * y; // &&& 错开且为+= i+j+1
            }
        }

        // 补余数
        for (int i=m+n-1; i>0; i--) {
            res[i-1] += res[i] / 10;
            res[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0; // 过滤首位为0的
        i = res[i] == 0 ? 1 : 0;
        for (; i<m+n; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        L43 l = new L43();
        var res = l.multiply("123", "456");
        System.out.println(res);
    }
}
