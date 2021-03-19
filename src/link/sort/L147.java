package link.sort;


import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 147. 对链表进行插入排序
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 1.插入排序
 */
public class L147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 有序链表与 cur 比较
        ListNode sortList = head, cur = head.next;  // &&& next

        while (cur != null) {
            if (sortList.val <= cur.val) {
                sortList = sortList.next;  // &&& sortList.next
            } else {
                ListNode prev = dummy;

                // 从头开始找位置
                while (prev.next.val <= cur.val) {  // &&& prev.next
                    prev = prev.next;
                }

                sortList.next = cur.next;

                // 找到比cur小的位置
                cur.next = prev.next;
                prev.next = cur;
            }

            cur = sortList.next;    // &&& cur
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{4, 7, 8, 9, 2, 10, 5, 7});

        L147 l = new L147();
        var res = l.insertionSortList(head);
        MyPrint.showList(res);
    }
}
