package array;

/**
 * 334. 递增的三元子序列
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 *
 * 1.两变量记录大小
 * small - mid - high
 */
public class L334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length == 0) return false;

        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= small) {
                small = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else if (nums[i] > mid){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        L334 l = new L334();
        var res = l.increasingTriplet(new int[]{1,2,3,4,5});
        System.out.println(res);
    }
}
