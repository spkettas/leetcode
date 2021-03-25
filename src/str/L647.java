package str;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 1.中间向两边扩展
 */
public class L647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int ans = 0;

        // &&& 2*n-1
        for (int i=0; i< 2*n - 1; i++) {
            int l = i/2, r = i/2 + i%2;  // &&& i%2
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        L647 l = new L647();
        var res = l.countSubstrings("aaa");
        System.out.println(res);
    }
}
