package trace;


import util.MyPrint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列II，有重复key
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 1. 回溯框架；过滤重复元素，先排序
 */
public class L47 {
    private List<List<Integer>> res;
    private boolean[] used;    // 记录访问情况

    public void permuteUnique(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重 i>0
            if (used[i] ||
                    (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;  // 两个状态量

            permuteUnique(nums, track);

            track.removeLast();
            used[i] = false;
        }
    }

    /**
     * 全排列II，有重复key
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();

        // 排序后便于去重
        Arrays.sort(nums);
        permuteUnique(nums, track);

        return res;
    }

    public static void main(String[] args) {
        L47 l = new L47();
        var res1 = l.permuteUnique(new int[]{1, 1, 2});
        MyPrint.showList(res1);
    }
}
