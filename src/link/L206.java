package link;

import util.*;

/**
 * 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 1. 迭代法
 * 2. 递归法
 */
public class L206 {
    // 1.迭代法
    public ListNode reverseList(ListNode head) {
       ListNode prev = null;
       ListNode cur = head;

       while (cur != null) {
           ListNode tmp = cur.next;
           cur.next = prev;

           prev = cur;
           cur = tmp;
       }

       return prev;
    }

    // 2.递归法
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) { // &&& head.next
            return head;
        }

        ListNode last = reverseList1(head.next);
        head.next.next = head;       // 接head
        head.next = null;            // head接null
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink();

        L206 l = new L206();
        //var node = l.reverseList(head);
        var node = l.reverseList1(head);
        MyPrint.showList(node);
    }
}
