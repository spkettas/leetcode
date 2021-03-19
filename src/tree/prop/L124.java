package tree.prop;


import util.TreeNode;
import util.TreeUtil;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 1.递归，与高度类似
 */
public class L124 {
    private int res;

    // 最大贡献值
    public int maxGain(TreeNode root) {
        if (root == null)  return 0;

        int left = Math.max(0, maxGain(root.left));      // 贡献值>0，不可能为负
        int right = Math.max(0, maxGain(root.right));

        int value = root.val + left + right;
        res = Math.max(res, value);

        return root.val + Math.max(left, right);    // 左右子树贡献最大值
    }

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;

        maxGain(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("-10,9,20,#,#,15,7,");

        L124 l = new L124();
        var res = l.maxPathSum(root);
        System.out.println(res);
    }
}
