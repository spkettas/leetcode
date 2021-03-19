package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 1.逆序相加，用栈结构
 */
public class L445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode p = l1;
        while (p != null) {
            s1.push(p);
            p = p.next;
        }

        p = l2;
        while (p != null) {
            s2.push(p);
            p = p.next;
        }

        int sum = 0, carray = 0;
        ListNode ans = null;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0 : s2.pop().val;
            sum = v1 + v2 + carray;
            carray = sum / 10;

            ListNode cur = new ListNode(sum % 10);
            cur.next = ans;
            ans = cur;  // 指针倒转
        }

        if (carray != 0) {
           ListNode last = new ListNode(carray);
           last.next = ans;
           ans = last;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.createLink(new int[]{7, 2, 4, 3});
        ListNode l2 = ListUtil.createLink(new int[]{5, 6, 4});

        L445 l = new L445();
        var res = l.addTwoNumbers(l1, l2);
        MyPrint.showList(res);
    }
}
