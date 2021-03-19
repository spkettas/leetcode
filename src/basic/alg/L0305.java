package basic.alg;


import java.util.Stack;

/**
 * 面试题 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 1.栈按顺序pop，引入辅助栈
 */
public class L0305 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;  // 小值中转站，最终还是会merge到stack1

    public L0305() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        // 挪
        while (!stack1.isEmpty() && stack1.peek() < val) {
            stack2.push(stack1.pop());
        }

        stack1.push(val);

        // 添加最小值在后，小值前出栈
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    public int peek() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        L0305 l = new L0305();
        l.push(8);
        l.push(10);
        l.push(3);

        while (!l.isEmpty()) {
            System.out.println(l.peek());
            l.pop();
        }
    }
}
