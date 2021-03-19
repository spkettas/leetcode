package dp;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]
 *
 * 1. dp
 * w*h升序排序，当w相同时，按h降序排序
 */
public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // 二维数组
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0] == 0 ? b[1]  - a[1] : a[0] - b[0];
            }
        });

        int n = envelopes.length;
        int[] height = new int[n];

        // 取h
        for (int i=0; i<n; i++) {
            height[i] = envelopes[i][1];
        }

        L300 l = new L300();
        return l.lengthOfLIS(height);
    }

    public static void main(String[] args) {
        L354 l = new L354();
        var res = l.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        System.out.println(res);
    }
}
