package trace;

import util.MyPrint;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 1. 回溯法
 */
public class L77 {
    private List<List<Integer>> res;

    /**
     * 1. bug1有重复 -> 添加起始参数
     */
    public void backtrace(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            //res.add(track);
            res.add(new LinkedList<>(track));
            return;
        }

        // &&& start
        for (int i=start; i<=n; i++) {
            if (track.contains(i)) {
                continue;
            }

            track.add(i);
            backtrace(n, k, i+1, track);
            track.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        // &&& start
        backtrace(n, k, 1, track);
        return res;
    }

    public static void main(String[] args) {
        L77 l = new L77();
        var res = l.combine(4, 2);
        MyPrint.showList(res);
    }
}
