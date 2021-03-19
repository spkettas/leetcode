package array.dpt;

/**
 * 287. 寻找重复数, o(1)复杂度, 1 <= nums[i] <= n
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 1. 双指针，与 寻找链表环入口 一致
 */
public class L287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0, fast = 0;

        // 首次相遇
        do {
          slow = nums[slow];
          fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;

        // 再次相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        L287 l = new L287();
        var res = l.findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(res);
    }
}
