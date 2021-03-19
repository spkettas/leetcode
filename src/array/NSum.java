package array;


import java.util.*;

/**
 * NSum 系列
 *
 */
public class NSum {
    public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (nums.length == 0) return list;

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
                list.add(tp);

                while (l < r && nums[r] == right) r--;
                while (l < r && nums[l] == left) l++;
            }
        }

        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (nums.length < 3) return list;

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Integer>> ans = twoSum(nums, i+1, 0 - nums[i]);  // &&& i+1 添加start防重

            for (int j = 0; j < ans.size(); j++) {
                ArrayList<Integer> tp = ans.get(j);

                tp.add(nums[i]);

                // sort
                Collections.sort(tp);
                list.add(tp);
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) i++;   // &&& 去重
        }

        return list;
    }

    public static void main(String[] args) {
        //int[] nums = {-2, 0, 1, 1, 2};
        int[] nums = {1,2,-2,-1};

        NSum o = new NSum();
        var res = o.threeSum(nums);
        System.out.println(res);
    }
}
