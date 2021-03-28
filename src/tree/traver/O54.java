package tree.traver;

import util.TreeNode;
import util.TreeUtil;

/**
 * Offer 54. 二叉搜索树的第k大节点
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 *
 * 1. 变形中序遍历，从right -> root -> left
 */
public class O54 {
    private int res;
    private int k;  // &&& 全局类变量

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);

        if (--k == 0) {
            res = root.val;
            return;
        }

        dfs(root.left);
    }

    public int kthLargest(TreeNode root, int k) {
        this.res = 0;
        this.k = k; // &&&

        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("5,3,6,2,4,#,#,1,#,");

        O54 o = new O54();
        var res = o.kthLargest(root, 3);
        System.out.println(res);
    }
}
