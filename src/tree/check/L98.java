package tree.check;

import util.TreeNode;
import util.TreeUtil;

/**
 * 验证二叉树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 * 1. 递归法，左右节点框架。但是需要额外变量标识min/max
 */
public class L98 {
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val < min.val)  return false;
        if (max != null && root.val > max.val)  return false;

        // left
        return isValidBST(root.left, min, root) &&
                isValidBST(root.right, root, max);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("2,1,3,#,#,#,#,");

        L98 l = new L98();
        var flag = l.isValidBST(root);
        System.out.println(flag);
    }
}
