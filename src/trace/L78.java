package trace;

import util.MyPrint;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 1. 递归
 * 2. 回溯法
 */
public class L78 {
    private List<List<Integer>> res;

    public void dfs(int[] nums, int start, LinkedList<Integer> track) {
        // 来者不拒
        res.add(new LinkedList<>(track));

        // &&& start
        for (int i=start; i<nums.length; i++) {
            track.add(nums[i]);
            dfs(nums, i + 1, track);
            track.removeLast();
        }
    }

    // 2. 回溯法
    public List<List<Integer>> subsets1(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        dfs(nums, 0, track);
        return res;
    }

    public static void main(String[] args) {
        L78 l = new L78();
        var res = l.subsets1(new int[]{1,2,3});
        MyPrint.showList(res);
    }
}
