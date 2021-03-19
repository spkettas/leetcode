package tree.traverse;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.*;

/**
 * 二叉树右视图
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 1. 按层遍历框架，map存储每层值
 */
public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }

        int depth = 0;
        Map<Integer, Integer> map = new HashMap<>();    // depth -> val
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cnt = q.size();

            // &&& cnt
            for (int i=0; i<cnt; ++i) {
                TreeNode cur = q.poll();

                if (!map.containsKey(depth)) {
                    map.put(depth, cur.val);
                }

                // 先加right
                if (cur.right != null) {
                    q.offer(cur.right);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }

            depth++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<depth; i++) {
            res.add(map.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5,#,#,#,#,");

        L199 l = new L199();
        var res = l.rightSideView(root);
        MyPrint.show(res);
    }
}
