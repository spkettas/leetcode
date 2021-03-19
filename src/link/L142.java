package link;

import util.ListUtil;
import util.ListNode;


/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 1. 快慢指针
 */
public class L142 {
    ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;     // &&& head

        // 直至两指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast) break;
        }

        // 找环
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createCycleLink();

        L142 l = new L142();
        var cycle = l.detectCycle(head);
        System.out.println("meet: " + cycle.val);
    }
}
