package tree.prop;

import util.TreeNode;
import util.TreeUtil;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 1. 与二叉树深度类似，节点 L + R 深度和
 */
public class L543 {
    private int res;

    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        // update
        res = Math.max(res, left + right + 1);  // 左右高度和

        // 返回该根高度
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        res = 0;

        depth(root);
        return res - 1; // 4边3长度
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,4,5,#,#,");

        L543 l = new L543();
        var res = l.diameterOfBinaryTree(root);
        System.out.println(res);
    }
}
