package array.dpt;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 1. 暴力搜索
 * 2. 双指针 *
 */
public class L42 {
    // 1. 暴力法
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int ans = 0;

        for (int i=0; i<n; i++) {
            int lmax = 0, rmax = 0; // &&& reset

            for (int j=i; j<n; j++) {
                lmax = Math.max(lmax, height[j]);
            }

            for (int j=i; j>=0; j--) {
                rmax = Math.max(rmax, height[j]);
            }

            ans += Math.min(lmax, rmax) - height[i];
        }

        return ans;
    }

    // 2. 双指针
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int ans = 0, lmax = 0, rmax = 0;

        while (left <= right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            // 盛水取决于短板
            if (lmax < rmax) {
                ans += lmax - height[left]; // &&& left
                left++;
            } else {
                ans += rmax - height[right];    // &&& right
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //int[] rain = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] rain = {3,1,2,5,2,4};
        int[] rain = {4,5,1,3,2};

        L42 l = new L42();
        var res = l.trap1(rain);
        System.out.println(res);

        res = l.trap(rain);
        System.out.println(res);
    }
}
