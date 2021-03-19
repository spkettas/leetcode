package basic.bin;

/**
 * 33. 搜索旋转排序数组，要求o(lgN)
 * 输入：nums = [4,5,6,7, 0,1,2], target = 0
 * 输出：4
 *
 * 1. 二分查找
 * 数组已被旋转，只有部分有序。还是可以采用二分查找
 * 升级后的二分查找，分为[0,mid] [mid, n-1] 两块区域; [l, mid) (mid, r]
 *
 */
public class L33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)  return 0;

        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)  return mid;

            // left 与 mid关系，分成两块. &&& <=
            if (nums[0] <= nums[mid]) {     // 左边
                if (nums[0] <= target && target < nums[mid]) {      // &&& [0, mid)
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {    // 右边
                if (nums[mid] < target && target <= nums[n - 1]) {  // &&& (mid, r]
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        L33 l = new L33();
        var res = l.search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(res);
    }
}
