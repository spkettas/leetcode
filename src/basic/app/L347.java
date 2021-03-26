package basic.app;

import util.MyPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 1. 快排，降序排列
 */
public class L347 {
    public void swap(List<int[]> a, int i, int j) {
        int[] tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public int partition(List<int[]> a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = a.get(lo)[1];    // 次数

        while (true) {
            // &&& <=
            while (++i <= hi && a.get(i)[1] > base);
            while (--j >= lo && a.get(j)[1] < base);

            // &&& >=
            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    public int[] topK(List<int[]> a, int k) {
        int lo = 0;
        int hi = a.size() - 1;

        // &&& lo<=hi
        while (lo <= hi) {
            int j = partition(a, lo, hi);

            if (j == k) {
                break;
            } else if (j < k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = a.get(i)[0];
        }

        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return new int[]{};
        else if (nums.length == k && k == 1) return new int[]{nums[0]};

        // num - count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> a = new ArrayList<>();

        // 提取list
        var keys = map.keySet();
        for (Integer v : keys) {
            a.add(new int[]{v, map.get(v)});
        }

        return topK(a, k);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        L347 l = new L347();
        var res = l.topKFrequent(nums, 2);
        MyPrint.show(res);
    }
}
