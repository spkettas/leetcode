package trace;

import util.MyPrint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列I
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 1. 回溯框架
 */
public class L46 {
    private List<List<Integer>> res;

    public void permute(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));   // &&&
            return;
        }

        // 选择状态
        for (int i=0; i<nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            permute(nums, track);
            track.removeLast();
        }
    }

    /**
     * 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();

        LinkedList<Integer> track = new LinkedList<>();
        permute(nums, track);

        return res;
    }

    public static void main(String[] args) {
        L46 l = new L46();
        var res = l.permute(new int[]{1, 2, 3});
        MyPrint.showList(res);
    }
}
