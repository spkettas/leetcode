package link;

import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 合并k个升序链表
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 1. 切分子问题，两个链表
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        L21 l = new L21();
        ListNode mergeLst = null;

        for (ListNode node : lists) {
            mergeLst = l.mergeTwoLists(mergeLst, node);
        }

        return mergeLst;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                ListUtil.createLink(new int[]{2, 3, 5, 7, 9}),
                ListUtil.createLink(new int[]{4, 8, 10, 11, 18}),
                ListUtil.createLink(new int[]{5, 8, 10, 12, 15})
        };

        L23 l = new L23();
        ListNode head = l.mergeKLists(lists);
        MyPrint.showList(head);
    }
}
