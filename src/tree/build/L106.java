package tree.build;

import util.TreeNode;
import util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 中序 + 后序 -> 二叉树。与L105类似
 *
 * 1. 递归法，定位root节点在中序遍历中位置
 * 后：[left right root]
 * 中：[left root right]
 */
public class L106 {
    // val - pos
    private Map<Integer, Integer> map;
    public TreeNode createTree(int[] post, int[] in, int postLeft, int postRight,
            int inLeft, int inRight) {
        if (postLeft > postRight) {     // &&& >
            return null;
        }

        int rootVal = post[postRight];
        int rootPos = map.get(rootVal);
        int leftCnt = rootPos - inLeft; // &&&

        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(post, in, postLeft, postLeft + leftCnt - 1,
                inLeft, rootPos - 1);   // rootPos
        root.right = createTree(post, in, postLeft + leftCnt, postRight - 1,
                rootPos + 1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0
                || postorder == null || postorder.length == 0) {
            return null;
        }

        int n = postorder.length;
        map = new HashMap<>();

        for (int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }

        return createTree(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        L106 l = new L106();
        var root = l.buildTree(inorder, postorder);
        TreeUtil.show(root);
    }
}
