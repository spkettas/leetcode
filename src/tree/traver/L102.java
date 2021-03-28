package tree.traver;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 1. 利用队列，注：每一层的数目
 */
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelCnt = queue.size();    // &&&

            for (int i=0; i<levelCnt; ++i) {    // 2 - 4 - 8
                TreeNode cur = queue.poll();
                level.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            } // for(;)

            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5,#,#,#,#,");

        L102 l = new L102();
        var res = l.levelOrder(root);
        MyPrint.showList(res);
    }
}
