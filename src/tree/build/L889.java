package tree.build;

import util.TreeNode;
import util.TreeUtil;

import java.util.Arrays;

/**
 * 前序 + 后序 -> 二叉树
 * 1. 递归法；比前+中序要困难，无法根据根节点划分左子树右子树。
 * 通过左子树后节点划分
 *
 * 左子树数目为L，不停递归
 * left:  pre[1:L+1] post[0:L]          # 切片前闭后开
 * right: pre[L+1:N] post[L:N-1]
 *
 * [root left right]
 * [left right root]
 *
 * 如： 7个元素
 * 前：3 [9 1 8] [20 15 7]
 * 中：19 8 3 15 20 7
 * 后：[1 8 9] [15 7 20] 3
 */
public class L889 {
    // pre[0] + pre[1]
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0
                || post == null || post.length == 0) {
            return null;
        }

        int N = pre.length;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        // 定位到左子树，pre[1] == post[i]
        int L = 0;  // &&& 左子树长度
        for (int i = 0; i < N; i++) {
            if (pre[1] == post[i]) {
                L = i + 1;
            }
        }

        // 只处理左右子树，排除根节点
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),     // [1,L+1)
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),        // [L+1,N)
                Arrays.copyOfRange(post, L, N - 1));

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        L889 l = new L889();
        var root = l.constructFromPrePost(inorder, postorder);
        TreeUtil.show(root);
    }
}
