package str;


import java.util.Stack;

/**
 * Offer 09. 用两个栈实现队列
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 *1. stack2为空时，才从stack1 copy
 * 从stack1挪到stack2
 */
public class O09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public O09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 导入到stack2，从stack2中弹出
        // &&& stack2.isEmpty()
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) return -1;

        return stack2.pop();
    }

    public static void main(String[] args) {
        O09 o = new O09();
        o.appendTail(1);
        o.appendTail(2);

        System.out.println(o.deleteHead());

        o.appendTail(3);
        System.out.println(o.deleteHead());
    }
}
