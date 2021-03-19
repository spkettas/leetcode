package tree.check;

import util.TreeNode;
import util.TreeUtil;

/**
 *剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 1.递归
 */
public class O27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);  // 左右交换
        root.right = mirrorTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("4,2,7,1,3,6,9,");

        O27 o = new O27();
        var res = o.mirrorTree(root);
        TreeUtil.show(res);
    }
}
