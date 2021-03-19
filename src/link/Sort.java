package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

import java.util.List;

/**
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 *
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 *
 * 1.分离奇偶 + 链表反转 + 合并有序链表
 * 1 3 5 7
 * 8 6 4 2
 */
public class Sort {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public ListNode sortOddEvenList(ListNode head) {
        if (head == null) return null;

        // 分离链表
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;    // &&& 奇数置空

        // 反转even链表
        ListNode l2 = reverse(evenHead);

        // 合并两个有序链表
        ListNode newHead = merge(head, l2);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{1,8,3,6,5,4,7,2});

        Sort s = new Sort();
        var res = s.sortOddEvenList(head);
        MyPrint.showList(res);
    }
}
