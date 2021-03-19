package tree.traverse;

import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 1. 递归法
 * 2. 迭代法
 *   左 - x - 右
 */
public class L94 {
    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    // 1. 递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)   return list;

        helper(root, list);
        return list;
    }

    // 2. 迭代法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)  return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;  // 极左
            }

            p = stack.pop();
            list.add(p.val);
            p = p.right;     // 极右
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5,#,#,#,#,");

        L94 l = new L94();
        var res = l.inorderTraversal1(root);
        MyPrint.show(res);
    }
}
