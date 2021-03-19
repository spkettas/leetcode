package tree.traverse;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 1. 层序遍历的变种
 */
public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftOrder = true;

        while (!queue.isEmpty()) {
            // 两端添加
            LinkedList<Integer> level = new LinkedList<>();
            int cnt = queue.size();

            for (int i=0; i<cnt; i++) {
                TreeNode cur = queue.poll();

                if (leftOrder) {
                    level.offerLast(cur.val);
                } else {
                    level.offerFirst(cur.val);
                }

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(new LinkedList<>(level));
            leftOrder = !leftOrder;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("3,9,20,#,#,15,7,");

        L103 l = new L103();
        var res = l.zigzagLevelOrder(root);
        MyPrint.showList(res);
    }
}
