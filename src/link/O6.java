package link;

import util.ListNode;
import util.ListUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指offer，从尾到头打印链表
 *
 * 1.stack
 * 2.递归
 */
public class O6 {
    // 1.入栈
    public void reverseLink(ListNode h) {
        LinkedList<ListNode> s = new LinkedList<>();

        ListNode node = h;
        while (node != null) {
            s.push(node);
            node = node.next;
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop().val);
        }
    }

    // 2.递归
    public void reverseLink1(ListNode h) {
        if (h != null) {
            if (h.next != null) {
                reverseLink1(h.next);
            }

            System.out.println(h.val);
        }
    }

    public static void main(String[] args) {
       var head = ListUtil.createLink(new int[]{1,2,3,4,5});

       O6 o = new O6();
       o.reverseLink(head);
       //o.reverseLink1(head);
    }
}
