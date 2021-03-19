package basic.alg;


import util.MyPrint;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * 1.单调栈，只放大的元素，单调递增
 * 2.num1是nums2的子集
 */
public class L496 {
    // 单调栈
    public int[] nextGreaterElement(int[] nums1) {
        if (nums1.length == 0) return new int[]{};

        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<>();

        // &&& 逆向
        for (int i=nums1.length-1; i>=0; i--) {
            // &&& <=
            while (!s.isEmpty() && s.peek() <= nums1[i]) {
                s.pop();    // 栈反向出栈，便于判断下一个最大元素
            }

            // &&& peek()
            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums1[i]);
        }

        return ans;
    }

    // 2.单调栈变形体，只需要求部分元素。用map缓存
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=nums2.length-1; i>=0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            map.put(nums2[i], s.isEmpty() ? -1 : s.peek());
            s.push(nums2[i]);
        }

        int n = nums1.length;
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ns1 = {2, 1, 2, 4, 3};

        L496 l = new L496();
        var res = l.nextGreaterElement(ns1);
        MyPrint.show(res);

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        var res1 = l.nextGreaterElement1(nums1, nums2);
        MyPrint.show(res1);
    }
}
