package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 */
public class L328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;

        // &&& even
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;    // &&& 连接奇偶链表
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{1,2,3,4,5});

        L328 l = new L328();
        var root = l.oddEvenList(head);
        MyPrint.showList(root);
    }
}
