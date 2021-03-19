package tree.prop;

import util.TreeNode;
import util.TreeUtil;

/**
 * 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 1. BST遍历框架，找+删
 */
public class L450 {
    public TreeNode getMin(TreeNode node) {
        // &&& node.left
        while (node.left != null)  node = node.left;
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)  return null;

        if (root.val == key) {
            // 1.无叶子节点, 2. 有一个叶子节点
            if (root.left == null)  return root.right;
            if (root.right == null)  return root.left;

            // 3. 有两个叶子节点，用右子树最小节点来代替  &&& root.right
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;

            // &&& 原右子树交换的节点要删除
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    public static void main(String[] args) {
        var root = TreeUtil.deserialize("5,3,6,2,4,#,7,");

        L450 l = new L450();
        var res = l.deleteNode(root, 3);
        TreeUtil.show(res);
    }
}
