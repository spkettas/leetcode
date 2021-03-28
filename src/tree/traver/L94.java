package tree.traver;

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
 * 2. 迭代法，用栈模拟
 *   左 - x - 右 顺序不变，添加数据时机不同
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
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)   return list;

        helper(root, list);
        return list;
    }

    // 1.前序遍历
    public List<Integer> frontTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)  return ans;

        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                ans.add(p.val);

                s.push(p);
                p = p.left;
            }

            p = s.pop();
            p = p.right;
        }

        return ans;
    }

    // 2. 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)  return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        // 左
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            // 中
            p = stack.pop();
            list.add(p.val);

            // 右
            p = p.right;
        }

        return list;
    }

    // 3.后序遍历
    public List<Integer> afterTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode p = root;
        TreeNode prev = null;

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            p = s.pop();
            //p = p.right;

            if (p.right == null || p.right == prev) {
                ans.add(p.val);
                prev = p;
                p = null;
            } else {
                s.push(p);  // &&&
                p = p.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,4,5,6,#,");

        L94 l = new L94();
        List<Integer> res;

        // 前序：1 2 4 5 3 6
        res = l.frontTraversal(root);
        MyPrint.show(res);

        // 中序：4 2 5 1 6 3
        res = l.inorderTraversal(root);
        MyPrint.show(res);

        // 后序：4 5 2 6 3 1
        res = l.afterTraversal(root);
        MyPrint.show(res);
    }
}
