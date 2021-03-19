package tree.check;

import com.sun.source.tree.Tree;
import util.TreeNode;
import util.TreeUtil;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 1.递归，比较两个值
 */
public class L101 {
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)  return true;

        if (p == null || q == null)  return false;
        if (p.val != q.val)  return false; // &&& false

        return check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        // 需要比较左右子树，则添加两个参数
        return check(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,2,#,3,#,3,");
        root = TreeUtil.deserialize("1,2,3,");

        L101 l = new L101();
        var res = l.isSymmetric(root);
        System.out.println(res);
    }
}
