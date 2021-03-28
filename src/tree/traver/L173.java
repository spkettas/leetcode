package tree.traver;


import util.TreeNode;
import util.TreeUtil;

import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 * 中序遍历
 *
 * 1.递归, 数组接收结果
 * 2.栈迭代
 */
public class L173 {
    private TreeNode cur;
    private LinkedList<TreeNode> stack;

    public L173(TreeNode root) {
        this.cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        // left
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        // cur
        cur = stack.pop();
        var ret = cur.val;
        cur = cur.right; // next
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,4,5,");

        L173 l = new L173(root);
        var res = l.hasNext();
        System.out.println(res);
    }
}
