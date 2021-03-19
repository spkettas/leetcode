package array;


import util.MyPrint;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 * 1.合并后排序
 * 3.双指针，从后往前移，不生成拷贝
 */
public class L88 {
    // 1.合并后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) return;

        // src -> dst
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 2.合并后排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        // &&& {1} -> {0} 特殊用例，拷贝单个元素
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        //int[] nums1 = {0};
        //int[] nums2 = {1};

        L88 l = new L88();
        l.merge(nums1, 3, nums2, 3);
        //l.merge1(nums1, 3, nums2, 3);
        //l.merge1(nums1, 0, nums2, 1);
        MyPrint.show(nums1);
    }
}
