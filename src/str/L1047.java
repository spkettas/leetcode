package str;


/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 1.与26题不一样，所有重复的都要删除。类似于有效括号
 * StringBuilder模拟Stack
 */
public class L1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.isEmpty())  return "";

        int n = S.length();
        StringBuilder sb = new StringBuilder();
        int top = -1;

        for (int i=0; i<n; i++) {
            char ch = S.charAt(i);

            if (top >= 0 && sb.charAt(top) == ch) {
                sb.deleteCharAt(top);   // 相同的弹出
                top--;
            } else {
                sb.append(ch);
                top++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        L1047 l = new L1047();
        var res = l.removeDuplicates("abbaca");
        System.out.println(res);
    }
}
