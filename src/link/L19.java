package link;

import util.ListNode;
import util.ListUtil;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 
 * 1. 快慢指针(fast先走n步，slow走一步)
 * 2. 双指针
 */
public class L19 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);  // &&& dummy
        dummy.next = head;
        ListNode fast;
        fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            dummy = dummy.next;
            fast = fast.next;
        }

        if (dummy.next == head) {
            head = head.next;
        } else {
            dummy.next = dummy.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.createLink(new int[]{1, 2, 4, 7, 9});
        ListNode l2 = new L19().removeNthFromEnd(l1, 2); 
        ListUtil.show(l2);
    }
}
