package link;


import util.ListNode;
import util.ListUtil;
import util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 1.哈希表
 * 2.双重循环
 */
public class L0201 {
    // 1.哈希
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode pos = head;    // 前驱

        while (pos.next != null) {
            ListNode cur = pos.next; // 本身

            if (set.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next; // pos指针一直未移动，直接没有重复数
            }
        }

        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        var head = ListUtil.createLink(new int[]{1, 2, 3, 3, 3, 2, 1});

        L0201 l = new L0201();
        var res = l.removeDuplicateNodes(head);
        MyPrint.showList(res);
    }
}
