package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;


/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 1.迭代法
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;   // &&& dummy

        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;  // 连接

            tmp = node1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{1,2,3,4});

        L24 l = new L24();
        var res = l.swapPairs(head);
        MyPrint.showList(res);
    }
}
