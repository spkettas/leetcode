package tree.check;


import trace.L22;
import util.TreeNode;
import util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 1. 层序遍历，交换左右节点
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)   return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode left = cur.left;

            // swap
            cur.left = cur.right;
            cur.right = left;

            if (cur.left != null)   q.add(cur.left);
            if (cur.right != null)   q.add(cur.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("4,2,7,1,3,6,9,");

        L226 l = new L226();
        var res = l.invertTree(root);
        TreeUtil.show(res);
    }
}
