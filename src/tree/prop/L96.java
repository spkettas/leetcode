package tree;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 1. dp
 * dp[i] += dp[i-1] * dp[i-j]   树个数依赖左右子树笛卡尔积
 * 2. 卡塔兰数
 */
public class L96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=n; ++i) {
            for (int j=1; j<=i; ++j) {
                dp[i] += dp[j-1] * dp[i-j]; // &&& j-1
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        L96 l = new L96();
        var res = l.numTrees(3);
        System.out.println(res);
    }
}
