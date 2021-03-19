package link;

import test.Test;
import util.TreeNode;
import util.TreeUtil;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 1. bfs
 */
public class L617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees(root1.left, root2.left);  // 同left
        merge.right = mergeTrees(root1.right, root2.right);
        return merge;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.deserialize("1,3,2,5,#,#,#,");
        TreeNode root2 = TreeUtil.deserialize("2,1,3,#,4,#,7,");

        L617 l = new L617();
        var res = l.mergeTrees(root1, root2);
        TreeUtil.show(res);
    }
}
