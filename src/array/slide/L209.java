package array.slide;

/**
 * 209. 长度最小的子数组
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 *
 * 1.双指针
 */
public class L209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)  return 0;

        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0, res = Integer.MAX_VALUE;

        while (right < n) {
            sum += nums[right];   // &&& end

            // 缩小
            while (sum >= s) {
                res = Math.min(res, right - left + 1); // &&& +1(0->1)
                sum -= nums[left];

                // &&& start
                left++;
            }

            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        L209 l = new L209();
        var res = l.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println(res);
    }
}
