package array;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 1. 辅助栈
 * min() O(1) 的复杂度是因为在push时已转置
 */
public class O30 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;  // 存放最小值

    public O30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x); // 添加min
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())) {
            stack2.pop();   // 同步
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
