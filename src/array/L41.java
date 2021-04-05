package array;

import util.MyPrint;

/**
 *41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 1.变形哈希表
 * 2.原地置换。 x-1位置上存放x
 */
public class L41 {
    // 1.变形哈希表
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;

        // 1.负数变正数
        for (int i=0; i<n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;    // 标记
            }
        }

        // 2.<的变成负数
        for (int i=0; i<n; ++i) {
            if (nums[i] <= n) {
                nums[i] = -Math.abs(nums[i]);
            }
        }

        // 3.找>0的数
        for (int i=0; i<n; ++i) {
            if (nums[i] > 0) return i+1;
        }

        return n + 1;
    }

    // 2.原地置换
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;

        for (int i=0; i<n; i++) {
            // x-1位置上放置x
            // &&& while <=n nums[i]-1
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] != i+1) {   // &&& i+1
                return i+1; // first
            }
        }

        return n+1;
    }

    public static void main(String[] args) {
        //int[] nums = {7,8,9,11,12};
        //int[] nums = {3,10,-1,1};
        int[] nums = {1,2,0};

        L41 l = new L41();
        var res = l.firstMissingPositive(nums);
        System.out.println(res);

        res = l.firstMissingPositive1(nums);
        System.out.println(res);
    }
}
