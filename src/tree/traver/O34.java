package tree.traver;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树和为某一定值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。*
 *               5     target=22
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 1.回溯法框架，直到叶子节点
 */
public class O34 {
    private List<List<Integer>> res = null;

    public void dfs(TreeNode root, int sum, LinkedList<Integer> track) {
        if (root == null)   return;

        // 选择
        track.add(root.val);
        sum -= root.val;

        // 追溯到子节点
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(track));
        }

        dfs(root.left, sum, track);
        dfs(root.right, sum, track);

        // 撤销选择
        track.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();

        LinkedList<Integer> track = new LinkedList<>();
        dfs(root, sum, track);  // &&& sum
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("5,4,8,11,#,13,4,7,2,#,#,5,1,");

        O34 o = new O34();
        var res = o.pathSum(root, 22);
        MyPrint.showList(res);
    }
}
