package array;


import java.util.*;

/**
 * NSum 系列
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 1. 暴力法 -> hash法
 * 2. 排序后双指针, l<r
 */
public class NSum {
    public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (nums.length == 0) return list;

        // sort nums
        Arrays.sort(nums);
        
        int n = nums.length;
        int l = start, r = n - 1;

        while (l < r) {
            int left = nums[l], right = nums[r];
            int sum = left + right;

            if (sum > target) {
                while (l < r && nums[r] == right) r--;
            } else if (sum < target) {
                while (l < r && nums[l] == left) l++;
            } else {
                ArrayList<Integer> tp = new ArrayList<Integer>();
                tp.add(left);
                tp.add(right);
                list.add(tp);   // {left, right}

                while (l < r && nums[r] == right) r--;
                while (l < r && nums[l] == left) l++;
            }
        }

        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (nums.length < 3) return list;

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Integer>> ans = twoSum(nums, i+1, target - nums[i]);  // &&& i+1 添加start防重

            for (int j = 0; j < ans.size(); j++) {
                ArrayList<Integer> tp = ans.get(j);
                tp.add(nums[i]);

                Collections.sort(tp);   // sort
                list.add(tp);
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) i++;   // &&& 去重
        }

        return list;
    }

    public static void main(String[] args) {
        //int[] nums = {-2, 0, 1, 1, 2};
        int[] nums = {1,2,-2,-1};
        int target = 1;

        NSum o = new NSum();
        var res = o.threeSum(nums, target);
        System.out.println(res);
    }
}
