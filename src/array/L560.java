package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 *
 * 1. 前缀和解法, 原理: sumi - sumj = k
 */
public class L560 {
    /**
     * 1.优化解法：优化O(N2)，用map
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        // preSum -> cnt
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // base class

        int res = 0, sumi = 0;
        for (int i=0; i<n; i++) {
            sumi += nums[i];
            int sumj = sumi - k;

            if (map.containsKey(sumj)) {
                res += map.get(sumj);   // +cnt
            }

            // &&& sumi
            map.put(sumi, map.getOrDefault(sumi, 0) + 1);  // &&& sumi
        }

        return res;
    }

    /**
     * 2.普通解法，计算整个数列和
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int ans = 0;
        // &&& sum[1] - sum[0]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        L560 l = new L560();
        int res = l.subarraySum(new int[]{1, 1, 1, 2}, 2);
        System.out.println(res);

        res = l.subarraySum1(new int[]{1, 1, 1, 2}, 2);
        System.out.println(res);
    }
}
