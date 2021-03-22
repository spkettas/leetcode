package array.dpt;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 1. 从中心向两边查找
 */
public class L5 {
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int n = s.length();
        String res = "";

        for (int i = 0; i < n; i++) {
            String s1 = palindrome(s, i, i);    // 奇数
            String s2 = palindrome(s, i, i + 1);    // 偶数

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    public static void main(String[] args) {
        L5 l = new L5();
        var res = l.longestPalindrome("babad");
        System.out.println(res);
    }
}
