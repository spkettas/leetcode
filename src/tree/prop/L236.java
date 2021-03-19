package tree.prop;

import util.TreeNode;
import util.TreeUtil;

/**
 * 二叉树公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 *
 * 1. 递归框架，明确状态
 */
public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // one
        if (root == p || root == q) return root;

        // recur
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // not or null
        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        // other
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        L236 l = new L236();
        var node = l.lowestCommonAncestor(root, left, right);
        System.out.println(node.val);
    }
}
