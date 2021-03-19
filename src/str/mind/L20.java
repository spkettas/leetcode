package str.mind;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 1.利用栈特性
 */
public class L20 {
    public char leftOf(char c) {
        if (c == ')')  return '(';
        else if (c == '}') return '{';
        return '[';
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int n = s.length();
        Stack<Character> stack = new Stack<>(); // &&& character

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);

            if ( c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // &&& (leftOf()==peek)
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();    // pop()时要判断元素是否为空
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        s = "()";

        L20 l = new L20();
        var flag = l.isValid(s);
        System.out.println(flag);
    }
}
