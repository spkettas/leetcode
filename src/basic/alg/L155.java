package basic.alg;

import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 *
 * 1.辅助栈
 */
public class L155 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;  // 辅助栈，添加最小值

    public L155() {
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


    public static void main(String[] args) {
        L155 l = new L155();
        l.push(-2);
        l.push(0);
        System.out.println(l.min());
    }
}
