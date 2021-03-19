package link;

import util.ListNode;
import util.ListUtil;

/**
 * 回文链表
 * input: 1->3 -> 7 -> 3 -> 1
 * output: true
 *
 * 1. 递归法
 * 模拟后序遍历，递归栈至结尾处。除头类变量left
 *
 * 2. 双指针法
 * a.寻找中点
 * b.反转
 * c.对比节点是否相等
 */
public class L234 {
    private ListNode left;  // 类变量

    public boolean traverse(ListNode right) {
        if (right == null)  return true;

        boolean res = traverse(right.next);  // &&& res

        // 后序遍历
        res = res && (left.val == right.val);
        left = left.next;   // 前移
        return res;
    }

    // 1.递归
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }


    // 2.迭代法
    public boolean isPalindrome1(ListNode head) {
        // 获取中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 链表为奇数时，偏移到右边
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = ListUtil.reverse(slow);

        // &&& right
        while (right != null) {
            if (left.val != right.val) return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.createLink(new int[]{1, 5, 4, 5, 1});
        boolean res = false;

        L234 l = new L234();
        //res = l.isPalindrome(head);
        res = l.isPalindrome1(head);
        System.out.println(res);
    }
}
