package link;

import util.ListNode;
import util.ListUtil;

/**
 * 2. 两数相加
 * input:
 * 2 -> 4 -> 3
 * 5 -> 6 -> 4
 * output: 7 -> 0 -> 8
 *
 * 1. 注意进位
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode tail = null;
        int sum = 0, carray = 0;

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;   // &&& !=
            int v2 = l2 != null ? l2.val : 0;
            sum = v1 + v2 + carray;
            carray = sum / 10;

            ListNode tmp = new ListNode(sum % 10);
            if (tail == null) {
                head = tail = tmp; // &&&
            } else {
                tail.next = tmp;
                tail = tail.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carray != 0) {
            tail.next = new ListNode(carray);
        }

        return head;
    }

    public static void main(String[] args) {
        // 1
        ListNode l1 = ListUtil.createLink(new int[]{2, 4, 3});
        ListNode l2 = ListUtil.createLink(new int[]{5, 6, 4});

        // 2
        l1 = ListUtil.createLink(new int[]{9,9,9,9,9,9,9});
        l2 = ListUtil.createLink(new int[]{9,9,9,9});

        L2 l = new L2();
        var res = l.addTwoNumbers(l1, l2);
        ListUtil.show(res);
    }
}
