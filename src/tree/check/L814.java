package tree.check;

import util.TreeNode;
import util.TreeUtil;

/**
 * 814. 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树。
 * 右图为返回的答案。
 * => 移除二叉村所有值为0的节点
 *
 * 1.递归；判断是否包含1，不包含置null
 */
public class L814 {
    public boolean containOne(TreeNode root) {
        if (root == null) return false;

        boolean left = containOne(root.left);
        boolean right = containOne(root.right);

        // &&& 移除不包含1的节点
        if (!left) root.left = null;
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }

    public TreeNode pruneTree(TreeNode root) {
        return containOne(root) ? root : null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,#,0,#,#,0,1,");

        L814 l = new L814();
        var res = l.pruneTree(root);
        TreeUtil.show(res);
    }
}
