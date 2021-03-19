package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * k个一组反转链表
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 1. 递归法
 * a. 反转[a,b]间节点
 * b. 连接a的后继节点
 */
public class L25 {
    // 反转[a,b]间的节点
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null, cur =a;

        while (cur != b) {
            ListNode tmp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = tmp;
        }

        return prev;   // &&&
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b = head;   // &&& 初始值

        // [a, b]
        // a.next

        // &&& k
        for (int i=0; i<k; ++i) {
            if (b == null) return head;
            b = b.next;
        }

        // 反转区间
        ListNode newHead = reverse(a, b);  // b -> a -> next
        // 合并
        a.next = reverseKGroup(b, k);   // &&& a.next
        return newHead; // &&&
    }

    public static void main(String[] args) {
        L25 l = new L25();

        ListNode head = ListUtil.createLink(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode nHead = l.reverseKGroup(head, 3);
        MyPrint.showList(nHead);
    }
}
