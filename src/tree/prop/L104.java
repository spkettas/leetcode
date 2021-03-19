package tree.prop;

import util.TreeNode;
import util.TreeUtil;

/**
 * 二叉树最大深度
 *
 * 1. 递归
 * 2. bfs
 */
public class L104 {
    // 1.最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 2.最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 1.叶子节点
        if (root.left == null && root.right == null) return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 2.有一节点为空
        if (root.left == null || root.right == null) return left + right + 1;

        // 3.均不为空
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5,#,#,#,#,");

        L104 l = new L104();
        int depth = l.maxDepth(root);
        System.out.println(depth);
    }
}
