package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 1. 反转前k个节点
 * 2. 反转一部分节点
 */
public class L92 {
    private ListNode successor = null;  // 后驱节点

    /**
     * 反转前k个节点
     */
    public ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {    // &&& head.next
            return head;
        }

        if (n == 1) {
            successor = head.next;  // n后前驱
            return head;
        }

        // --
        ListNode last = reverseN(head.next, n - 1); // &&&
        head.next.next = head;  // 对接head
        head.next = successor;  // 对接last
        return last;    // 最后的节点
    }

    /**
     * 反转部分链表，递归子链表
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        // &&& head.next -> m - 1
        head.next = reverseBetween(head.next, m - 1, n - 1);  // &&& head
        return head;
    }

    public static void main(String[] args) {
        L92 l = new L92();

        ListNode head, nHead;

        // reverseN
        head = ListUtil.createLink(new int[]{1, 2, 3, 4, 5, 6});
        nHead = l.reverseN(head, 3);
        MyPrint.showList(nHead);

        // between
        head = ListUtil.createLink(new int[]{1, 2, 3, 4, 5, 6});
        nHead = l.reverseBetween(head, 2, 4);
        MyPrint.showList(nHead);
    }
}
