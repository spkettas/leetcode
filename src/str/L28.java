package str;


/**
 * 字符串查找
 */
public class L28 {
    // 1.暴力法
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;

            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        L28 l = new L28();
        var i = l.strStr("hello", "ll");
        System.out.println(i);
    }
}
