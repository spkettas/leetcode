package array.dpt;


import util.ListNode;
import util.ListUtil;
import util.MyPrint;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class L26 {
    // 1.数组去重 *
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0)  return 0;

        int i = 0;
        for (int j=1; j<nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;    // &&& 跳过0
                nums[i] = nums[j];
            }
        }

        return i + 1;  // +1
    }

    // 2.数组去重
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)  return 0;

        int n = nums.length;
        int slow = 0, fast = 1;

        // &&& fast
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;  // &&&
                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    /**
     * 3.链表去重
     */
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null)  return null;

        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;   // 与数组一样
                slow = slow.next;   // &&&
            }

            fast = fast.next;
        }

        slow.next = null;   // &&&
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        L26 l = new L26();

        // 0
        var res = l.removeDuplicates(nums);
        MyPrint.show(nums);
        System.out.println(res);

        int[] nums1 = {1,1,2,2,8,9,10};

        // 1
        res = l.removeDuplicates1(nums1);
        MyPrint.show(nums1);
        System.out.println(res);

        var root = ListUtil.createLink(new int[]{1,1,1,2,2,3});
        var newLink = l.removeDuplicates(root);
        MyPrint.showList(newLink);
    }
}
