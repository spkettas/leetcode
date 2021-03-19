package array;

import util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 1.排序求最大值，更新结果
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};

        // &&&
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();     // &&& int[]

        for (int i=0; i<intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {   // 不包含
                merged.add(new int[]{l, r});
            } else { // 包含
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }

        /*
        int[][] ans = new int[merged.size()][2];
        for (int i=0; i<merged.size(); i++) {
            ans[i] = merged.get(i);
        }
        return ans;
         */

        return merged.toArray(new int[merged.size()][]);    // &&& toArray()
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        L56 l = new L56();

        var res = l.merge(intervals);
        MyPrint.show(res);
    }
}
