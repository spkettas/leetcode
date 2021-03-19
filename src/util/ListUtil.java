package util;

/**
 * 链表工具库
 */
public class ListUtil {
    public static void show(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println();
    }

    /**
     * 构造链表 1-2-3-4-5
     */
    public static ListNode createLink() {
        int[] a = new int[]{1, 2, 3, 4, 5};

        ListNode head = createLink(a);
        return head;
    }

    public static ListNode createLink(int[] a) {
        ListNode cur = null;
        ListNode prev = null;

        for (int i = a.length - 1; i >= 0; --i) {
            cur = new ListNode(a[i]);
            cur.next = prev;

            prev = cur;
        }

        return cur;
    }

    /**
     * 构造链表 1-2-3-4-5-6-7->4
     */
    public static ListNode createCycleLink() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l7.next = l4;
        l6.next = l7;
        l5.next = l6;
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        return l1;
    }

    /**
     * 获取链表中点
     * 1. 双指针
     */
    public static ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 倒数第k个点
     * 1. 双指针
     */
    public static ListNode getKNode(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode slow, fast;
        slow = fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 反转链表
     */
    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;

            // prev前置了
            cur.next = prev;
            prev = cur;

            cur = tmp;
        }

        return prev;
    }

    public static ListNode reverse1(ListNode head) {
        // &&& head.next == null; return head;
        if (head == null || head.next == null) return head;

        ListNode last = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = createLink(new int[]{1, 2, 3, 4, 5});
        MyPrint.showList(head);

        //ListNode prev = reverse(head);
        ListNode prev = reverse1(head);
        MyPrint.showList(prev);
    }
}
