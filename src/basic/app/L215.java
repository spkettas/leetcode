package basic.app;

/**
 * 数组中第k个最大数
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class L215 {
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1; // &&&
        int base = a[lo];

        while (true) {
            while (++i <= hi && a[i] < base);   // &&& <=
            while (--j >= lo && a[j] > base);

            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        if (a.length == 0 || K > a.length) return -1;
        if (a.length == K && K == 1) return a[0];

        int target = a.length - K;
        int lo = 0;
        int hi = a.length - 1;
        int j = partition(a, lo, hi);

        while (true) {
            if (j == target) {  // &&& target
                return a[j];
            } else if (j > target) {
                hi = j - 1;
                j = partition(a, lo, hi);
            } else {
                lo = j + 1;
                j = partition(a, lo, hi);
            }
        }
    }

    public static void main(String[] args) {
        //int[] a = {1,3,5,2,2};
        //int[] a = {1};
        int[] a = {1,2,3,4,5,6};

        L215 l = new L215();
        //var res = l.findKth(a, 5, 3);
        //var res = l.findKth(a, 5, 1);
        var res = l.findKth(a, 5, 1);
        System.out.println(res);
    }
}
