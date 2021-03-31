package basic;

import util.AlgUtil;
import util.MyPrint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 三种排序算法
 *
 * 1. 冒泡排序
 * 2. 归并排序 (lo,mid,hi). 简化为：while(++i <= hi && a[i] < v)
 * 3. 快速排序 (lo,hi)
 */
public class MySort {
    /**
     * 冒泡排序, 前 与 后比较
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] > nums[j]) {
                    AlgUtil.swap(nums, i, j);
                }
            }
        }
    }

    private static int[] aux = null;    // 辅助空间

    /**
     * 归并排序，与快排类似，需辅助空间
     */
    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        // [lo,mid] [mid+1,hi]
        mergeSort(nums, lo, mid);   // 闭合
        mergeSort(nums, mid + 1, hi);

        // &&& +mid
        merge(nums, lo, mid, hi);
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        // copy
        for (int k=lo; k<=hi; ++k) {
            aux[k] = nums[k];
        }

        // merge a[lo,mid] + a[mid+1, hi]
        int i = lo;
        int j = mid + 1;    // &&&

        // 按区间拷贝，aux指针自移动
        for (int k=lo; k<=hi; ++k) {  // &&& <=
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[i] < aux[j]) nums[k] = aux[i++]; // &&& i++
            else nums[k] = aux[j++]; // &&& j++
        }
    }

    /**
     * 快速排序
     * @param nums
     */
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int lo, int hi) {
        // &&& =
        if (lo >= hi) {
            return;
        }

        // [lo,mid-1] [mid+1,hi]
        int mid = partition(nums, lo, hi);
        quickSort(nums, lo, mid - 1);    // 开区间
        quickSort(nums, mid + 1, hi);
    }

    public static int partition1(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1; // --j
        int base = a[lo];

        while (true) {
            // 左半部
            while (a[++i] < base) {
                if (i == hi) break;
            }

            // 右半部
            while (a[--j] > base) {
                if (j == lo) break;
            }

            // last
            if (i >= j) {
                break;
            }

            AlgUtil.swap(a, i, j);
        }

        AlgUtil.swap(a, lo, j);
        return j;
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1; // --j
        int base = a[lo];

        while (true) {
            // 左半部 <=
            while (++i <= hi && a[i] < base);

            // 右半部 >=
            while (--j >= lo && a[j] > base);

            // last
            if (i >= j) {
                break;
            }

            AlgUtil.swap(a, i, j);
        }

        AlgUtil.swap(a, lo, j);
        return j;
    }

    /**
     * 桶排序，每个桶维护一个小链表. List<List<Integer>>
     * O(n+c)  o(n+m)
     */
    public static void bucketSort(int[] a) {
        if (a.length == 0) return;

        int n = a.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 确定桶的数量
        for (int i=0; i<n; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        // 初始化
        int cnt = (max - min) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cnt);
        for (int i=0; i<cnt; i++) {
            buckets.add(new ArrayList<>());
        }

        // 放桶
        for (int i=0; i<n; i++) {
            int num = (a[i] - min) / n;
            buckets.get(num).add(a[i]);
        }

        // 每个桶排序
        for (int i=0; i<cnt; i++) {
            Collections.sort(buckets.get(i));
        }

        int k = 0;

        // 合并
        for (int i=0; i<cnt; i++) {
            List<Integer> list = buckets.get(i);

            for (int j=0; j<list.size(); j++) {
                a[k++] = list.get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {15, 10, 8, 22, 7, 9, 11};
        //int[] nums = {1,3,5,2,2};
        //int[] nums = {1,2,3,4,5,6};

        //MySort.bubbleSort(nums);
        MySort.mergeSort(nums);
        //MySort.quickSort(nums);
        //MySort.bucketSort(nums);

        MyPrint.show(nums);
    }
}
