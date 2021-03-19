package tree.prop;

import util.TreeNode;
import util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小高度
 *
 * 1. bfs
 * 2. dfs
 */
public class L111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cnt = q.size();

            for (int i=0; i<cnt; ++i) {
                TreeNode cur = q.poll();

                // 最小高度
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5,#,#,#,#,");

        L111 l = new L111();
        int depth = l.minDepth(root);
        System.out.println(depth);

        depth = new L104().minDepth(root);
        System.out.println(depth);
    }
}
