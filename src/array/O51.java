package array;

/**
 * 数组中逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 1.暴力法
 * 2.归并排序，l指向数字比r-1大，则贡献逆序对+1
 */
public class O51 {
    // 1.暴力法
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > nums[j]) cnt++;
            }
        }

        return cnt;
    }

    private int[] temp;

    // 2. 归并排序
    public int reversePairs1(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int len = nums.length;
        temp = new int[len];
        return reversePairs(nums, 0, len - 1);
    }

    public int reversePairs(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;
        int loPairs = reversePairs(nums, lo, mid);
        int hiPairs = reversePairs(nums, mid + 1, hi);

        // 已排好序
        if (nums[mid] <= nums[mid + 1]) {
            return loPairs + hiPairs;
        }

        int crossPairs = mergeAndCount(nums, lo, mid, hi);
        return loPairs + hiPairs + crossPairs;
    }

    public int mergeAndCount(int[] nums, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = nums[k];
        }

        int i = lo;
        int j = mid + 1;
        int count = 0;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > hi) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);     // &&&
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 6, 4};
        O51 o = new O51();

        //var res = o.reversePairs(a);
        var res = o.reversePairs1(a);
        System.out.println(res);
    }
}
