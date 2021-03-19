package tree.check;

import util.TreeNode;
import util.TreeUtil;

/**
 * 110. 平衡二叉树
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 1.递归
 * a. height(left) - height(right) <=1
 * b. 子树也是平衡二叉树
 */
public class L110 {
    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // &&&

        return (Math.abs(height(root.left) - height(root.right)) <= 1)
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtil.deserialize("3,9,20,#,#,15,7,");

        L110 l = new L110();
        var res = l.isBalanced(head);
        System.out.println(res);
    }
}
