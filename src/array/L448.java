package array;

import util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 1. 用数组代替哈希表, 改变每个元素的值
 * 2. hash
 */
public class L448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<Integer>();

        // [1, n]
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;   // 填坑
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        L448 l = new L448();
        var res = l.findDisappearedNumbers(nums);
        MyPrint.show(res);
    }
}
