package array.dpt;

import util.ListNode;
import util.MyPrint;

/**
 * 80. 删除排序数组中的重复项II
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 1.双指针，添加计数
 */
public class L80 {
    // 1.数组去重
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // i j 慢快指针
        int n = nums.length;
        int i = 0, count = 1;

        for (int j=1; j<n; j++) {
            if (nums[j] == nums[j-1]) {  // &&& ==
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};   // 7

        L80 l = new L80();
        var res = l.removeDuplicates(nums);
        MyPrint.show(nums);
        System.out.println(res);
    }
}
