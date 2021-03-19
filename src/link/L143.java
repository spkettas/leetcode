package link;


import util.ListNode;
import util.ListUtil;
import util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 1-2-3-4  ->   1-4-2-3
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3
 *
 * 1. 通过附加数组将链表变成可索引
 *    双指针，尾要连接起来
 *
 */
public class L143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            list.add(p);
            p = p.next;
        }

        // 双指针
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);     // 1 -> 4
            i++;

            // &&& i==j
            if (i == j) break;

            list.get(j).next = list.get(i);     // &&& 4 -> 2
            j--;
        }

        // &&& 置空
        list.get(i).next = null;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{1, 2, 3, 4});

        L143 l = new L143();
        l.reorderList(head);
        MyPrint.showList(head);
    }
}
