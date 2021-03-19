package link;

import util.ListNode;
import util.ListUtil;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 *
 * 1. 双指针；技巧，A/B一方走完后，再回到B/A开始走，所走的路程一样，即会相遇k
 */
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa==null) ? headB : pa.next;  // &&& 回到头部
            pb = (pb==null) ? headA : pb.next;
        }

        return pa;
    }

    public static void main(String[] args) {
        var headA = ListUtil.createLink(new int[]{4,1,8,4,5});
        ListNode mid = headA.next.next;
        var headB = ListUtil.createLink(new int[]{5,0,1});
        headB.next.next = mid;

        L160 l = new L160();
        var res = l.getIntersectionNode(headA, headB);
        System.out.println(res.val);
    }
}
