package tree.build;

import util.TreeNode;
import util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序 + 中序  -> 二叉树
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * 1. 递归解法. 在中序遍历中定位左右子树进行递归, +map快速索引
 * [ root left right ]
 * [ left root right ]
 */
public class L105 {
    // 中序遍历映射：val -> idx
    private Map<Integer, Integer> map;

    public TreeNode createTree(int[] preorder, int[] inorder, int pre_left, int pre_right,
                               int in_left, int in_right) {
        // &&& 退出条件
        if (pre_left > pre_right) {
            return null;
        }

        int rootVal = preorder[pre_left];
        int rootPos = map.get(rootVal);
        int leftCnt = rootPos - in_left;

        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(preorder, inorder, pre_left + 1, pre_left + leftCnt,
                in_left, rootPos - 1);
        root.right = createTree(preorder, inorder, pre_left + leftCnt + 1, pre_right,
                rootPos + 1, in_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }

        int n = inorder.length;
        map = new HashMap<>();  // &&&

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i); // inorder
        }

        return createTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inodrer = {9, 3, 15, 20, 7};

        L105 l = new L105();
        var root = l.buildTree(preorder, inodrer);
        TreeUtil.show(root);
    }
}
