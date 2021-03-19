package str.mind;

import java.util.Stack;

/**
 * 最长有效括号
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 1. stack 括号问题大多可用栈解决
 */
public class L32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1); // 占位

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {  // 不匹配
                    stack.push(i);
                } else {    // 压轴
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        L32 l = new L32();
        var res = l.longestValidParentheses("(()");
        System.out.println(res);
    }
}
