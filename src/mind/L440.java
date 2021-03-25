package mind;

/**
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 输入:
 * n: 13   k: 2
 * 输出:
 * 10
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 *
 * 1.十叉树搜索
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/shi-cha-shu-by-powcai/
 */
public class L440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;

        // 二分查找
        while (k > 0) {
            int count = getStep(n, cur, cur + 1);    // 当前前缀和

            if (count <= k) {  // 需要向右移动
                k -= count;
                cur++;
            } else {    // 1和2之间，需要下一层
                k--;    // 先走一步，向下走
                cur *= 10;
            }
        }

        return cur;
    }

    // 移动步数, n1/n2会溢出 -> long
    public int getStep(int n, long n1, long n2) {
        int count = 0;

        while (n1 <= n) {
            count += Math.min(n2, n+1) - n1; // &&& + 下一前缀与当前前缀差
            n1 *= 10;
            n2 *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        L440 l = new L440();
        var res = l.findKthNumber(13, 2);
        System.out.println(res);
    }
}
