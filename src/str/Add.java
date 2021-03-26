package str;

/**
 * 大数加法
 *
 * 1 + 99 - > 100
 *
 * 1. 反转
 */
public class Add {
    public char[] reverse(String s) {
        if (s.length() == 0) return new char[]{};

        char[] ch = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;

            l++;
            r--;
        }

        return ch;
    }

    public String solve (String s, String t) {
        // 反转
        char[] l1 = reverse(s);
        char[] l2 = reverse(t);

        int i = 0, m = l1.length;
        int j = 0, n = l2.length;

        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;

        // 加法
        while (i < m || j < n) {
            int v1 = (i >= m) ? 0 : l1[i++] - '0';
            int v2 = (j >= n) ? 0 : l2[j++] - '0';
            sum = v1 + v2 + carry;
            carry = sum / 10;

            sb.append(sum % 10);
        }

        if (carry != 0)  sb.append(carry);

        // 反转
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Add o = new Add();
        var res = o.solve("110", "192");
        System.out.println(res);
    }
}
