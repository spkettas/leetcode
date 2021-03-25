package tree.prop;

import util.TreeNode;
import util.TreeUtil;

/**
 * 相同的树
 *
 * 1.递归
 */
public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)  return true;
        if (p == null || q == null)  return false;
        if (p.val != q.val)  return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,");

        L100 l = new L100();
        var res = l.isSameTree(root, root);
        System.out.println(res);
    }
}
