package trace;


import util.MyPrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 1.以数组idx作为序列; [数字可无限]
 */
public class L39 {
    private List<List<Integer>> res;

    public void dfs(int[] candi, int target, int idx, LinkedList<Integer> track) {
        if (idx == candi.length) return;

        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }

        dfs(candi, target, idx + 1, track); // &&& 取下一位

        // &&& 数组可重复, 小于0则不需要再回溯
        if (target - candi[idx] >= 0) {
            track.add(candi[idx]);
            dfs(candi, target - candi[idx], idx, track); // &&& 当前取n位
            track.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        dfs(candidates, target, 0, track);
        return res;
    }

    public static void main(String[] args) {
        int[] candi = {2, 3, 6, 7};
        L39 l = new L39();
        var res = l.combinationSum(candi, 7);
        MyPrint.showList(res);
    }
}
