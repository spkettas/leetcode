package link.sort;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 1.与合并有序链表类似
 * small + large
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallHead  = small;
        ListNode largeHead  = large;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }

            cur = cur.next;
        }

        large.next = null; // 结尾
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode root = ListUtil.createLink(new int[]{1,4,3,2,5,2});

        L86 l = new L86();
        var res = l.partition(root, 3);
        MyPrint.showList(res);
    }
}
