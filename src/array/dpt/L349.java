package array.dpt;

import util.MyPrint;

import java.util.Arrays;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 1.添加哈希判断
 * 2.排序 + 双指针，需要防重
 */
public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        int m = nums1.length;
        int n = nums2.length;

        // sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx = 0, idx1 = 0, idx2 = 0;
        int[] res = new int[m + n];

        while (idx1 < m && idx2 < n) {
            int n1 = nums1[idx1], n2 = nums2[idx2];

            if (n1 == n2) {
                // 防重
                if (idx == 0 || n1 != res[idx - 1]) {
                    res[idx++] = n1;
                }

                idx1++;
                idx2++;
            } else if (n1 < n2) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return Arrays.copyOfRange(res, 0, idx);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};

        L349 l = new L349();
        var res = l.intersection(nums1, nums2);
        MyPrint.show(res);
    }
}
