package tree.prop;

import com.sun.source.tree.Tree;
import util.TreeNode;
import util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树路径总和III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 1. 前缀和. sumi -> sumj
 */
public class L437 {
    public int dfs(TreeNode root, int target, int curSum, Map<Integer, Integer> map) {
        if (root == null)  return 0;

        curSum += root.val;
        int sumj = curSum - target;

        int res = 0;
        res += map.getOrDefault(sumj, 0); // &&& res
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        // 递归
        res += dfs(root.left, target, curSum, map);
        res += dfs(root.right, target, curSum, map);

        // 撤销
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return res;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)  return 0;

        // sum - cnt
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        // 缺一参数
        return dfs(root, sum, 0, map);  // &&& curSum
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("10,5,-3,3,2,#,11,3,-2,#,1,#,#,");

        L437 l = new L437();
        var res = l.pathSum(root, 8);
        System.out.println(res);
    }
}
