package tree.prop;


import util.TreeNode;
import util.TreeUtil;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 *
 * 1.BST遍历，找+改
 */
public class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // &&& new
        if (root == null)  return new TreeNode(val);

        if (root.val == val) {

        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);    // &&& right
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    public static void main(String[] args) {
        var root = TreeUtil.deserialize("4,2,7,1,3,#,#,");

        L701 l = new L701();
        var res = l.insertIntoBST(root, 5);
        TreeUtil.show(res);
    }
}
