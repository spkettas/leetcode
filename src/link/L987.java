package link;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *
 * 1.以列顺序排列，dfs后排序后添加
 */
public class L987 {
    private List<Location> locs;

    public void dfs(TreeNode root, int x, int y) {
        if (root == null)  return;

        locs.add(new Location(x, y, root.val));
        dfs(root.left, x - 1, y+1); // left
        dfs(root.right, x + 1, y+1); // right
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locs = new ArrayList<>();

        // 收集节点
        dfs(root, 0, 0);
        Collections.sort(locs);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // 空

        // 不同x轴需分配空间
        int prev = locs.get(0).x;
        for (var loc : locs) {
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<>());  // 空
            }

            // 填充数据
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("3,9,20,#,#,15,7,");

        L987 l = new L987();
        var res = l.verticalTraversal(root);
        MyPrint.showList(res);
    }
}


class Location implements Comparable<Location>{
    int x;
    int y;
    int val;

    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location o) {
        if (x != o.x) {
            return x - o.x;
        } else if (y != o.y) {
            return y - o.y;
        } else {
            return val - o.val;
        }
    }
}