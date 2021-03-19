package link.sort;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;


/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。o(nlgn)
 *
 * 1.归并排序; 不解点对两个子链分别排序（递归一下了事）
 * > 链表排序居然不需要辅助空间
 */
public class L148 {
    // 获取链表中点
    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;

            if (fast != tail) {
                fast = fast.next;  // &&&
            }
        }

        return slow;
    }

    // 合并有序链表
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
            }

            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;   // &&&

        // &&&
        if (head.next == tail) {
            head.next = null;   // 排序完成
            return head;
        }

        ListNode mid = getMid(head, tail);
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        return merge(l1, l2);
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{4, 7, 8, 9, 2, 10, 5, 7});

        L148 l = new L148();
        var res = l.sortList(head);
        MyPrint.showList(res);
    }
}
