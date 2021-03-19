package str;

import javax.xml.transform.Source;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 1.栈特性，分析 1 [ ] 三种情况
 * getNum(); getString()
 * addLast(); removeLast()
 */
public class L394 {
    private int ptr;

    public String decodeString(String s) {
        if (s == null || s.isEmpty())  return s;

        ptr = 0;
        LinkedList<String> stack = new LinkedList<>();  // 当作栈

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);

            // 数字
            if (Character.isDigit(cur)) {
                String num = getNum(s);
                stack.addLast(num);
            } else if (Character.isLetter(cur) || cur == '[') {    // 字母 or [
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {    // ]
                ptr++;

                /*
                // 获取[ 后面的范围
                while (!"[".equals(stack.peekLast())) {
                    sb.append(stack.removeLast());
                }
                String content = sb.reverse().toString();
                */

                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }

                Collections.reverse(sub);   // 反转的是整个块，不是单个字符，不能用StringBuilder
                String content = getString(sub);

                stack.removeLast(); // 移除[

                StringBuilder sb = new StringBuilder();
                int repeat = Integer.parseInt(stack.removeLast());
                while (--repeat >= 0) {
                    sb.append(content);
                }

                stack.addLast(sb.toString());   // &&& 再次入栈
            }
        }

        return getString(stack);
    }

    public String getNum(String s) {
        StringBuilder sb = new StringBuilder();

        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }

        return sb.toString();
    }

    public String getString(LinkedList<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String line : stack) {
            sb.append(line);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String ret = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef";

        L394 l = new L394();
        var res = l.decodeString(s);
        System.out.println(res.equals(ret));
    }
}
