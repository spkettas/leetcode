package array.dpt;

/**
 * 4. 寻找两个正序数组的中位数
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 1.数组合并
 * 2.双指针，不符合要求
 * 3. 二分查找：两个有序数组第k小的数
 */
public class L4 {
    // 2. 双指针 o(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; // a
        int n = nums2.length; // b
        int cnt = m + n;

        int left = -1, right = -1;
        int aPos = 0, bPos = 0;

        // &&& <=
        for (int i = 0; i <= cnt / 2; i++) {
            left = right;

            // &&& && 拷贝较小数
            if (aPos < m && (aPos >= n || nums1[aPos] < nums2[bPos])) {
                right = nums1[aPos++];
            } else {
                right = nums2[bPos++];
            }
        }

        // 偶数
        if ((cnt & 1) == 0) {
            return (left + right) / 2.0;    // &&& 2.0
        }

        return right;
    }

    public int getKElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界
            if (index1 == m) return nums2[index2 + k - 1];   // &&& +k
            if (index2 == n) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);

            // 正常情况
            int h = k / 2;
            int newIndex1 = Math.min(index1 + h, m) - 1;    // &&& -1
            int newIndex2 = Math.min(index2 + h, n) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;  // 小的前移
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    // 3. 寻找k小数 o(lg(m+n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;

        if ((len & 1) == 1) {   // 奇数
            int kId = len / 2;
            double mid = getKElement(nums1, nums2, kId + 1);
            return mid;
        } else {    // 偶数
            int kId1 = len / 2 - 1, kId2 = len / 2;
            double mid = (getKElement(nums1, nums2, kId1 + 1) + getKElement(nums1, nums2, kId2 + 1)) / 2.0;
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        L4 l = new L4();
        double res = 0;

        //res = l.findMedianSortedArrays(nums1, nums2);
        //System.out.println(res);

        //res = l.findMedianSortedArrays1(new int[]{1, 3}, new int[]{});
        res = l.findMedianSortedArrays1(nums1, nums2);
        System.out.println(res);
    }
}
