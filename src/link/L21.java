package link;

import util.ListUtil;
import util.ListNode;
import util.MyPrint;

/**
 * 合并两个有序链表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 1. 迭代法；三个链表均要移动
 */
public class L21 {
    /**
     * 主指针、子指针都要移动
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 虚拟头
        ListNode head = new ListNode(-1);
        ListNode tail = head;

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

        // 剩余链表
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.createLink(new int[]{1, 2, 4, 7, 9});
        ListNode l2 = ListUtil.createLink(new int[]{3, 4, 4, 12, 25});

        L21 l = new L21();
        ListNode l3 = l.mergeTwoLists(l1, l2);
        MyPrint.showList(l3);
    }
}
