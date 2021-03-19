package array.slide;


/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 1. 滑动窗口思想，分为固定A，固定B两种情况，然后另一方移动
 *
 */
public class L718 {
    public int maxLength(int[] A, int[] B, int aPos, int bPos, int len) {
        int ans = 0, k = 0;

        for (int i=0; i<len; i++) {
            if (A[aPos + i] == B[bPos + i]) {
                k++;
            } else {
                k = 0;
            }

            ans = Math.max(ans, k);
        }

        return ans;
    }

    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m == 0 || n == 0)  return 0;

        int ans = 0, pLen = 0;

        // 固定B
        for (int i=0; i<m; i++) {
            int len = Math.min(n, m - i);   // &&& m-i
            pLen = maxLength(A, B, i, 0, len);
            ans = Math.max(ans, pLen);
        }

        // 固定A
        for (int i=0; i<m; i++) {
            int len = Math.min(m, n - i);
            pLen = maxLength(A, B, 0, i, len);
            ans = Math.max(ans, pLen);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};

        L718 l = new L718();
        var res = l.findLength(A, B);
        System.out.println(res);
    }
}
