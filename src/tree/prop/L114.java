package tree.prop;


import array.dpt.L11;
import util.MyPrint;
import util.TreeNode;
import util.TreeUtil;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 1.先序遍历后破坏左子树，利用变形的后序遍历
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 */
public class L114 {
    private TreeNode prev, head;

    // 1.废弃
    public void dfs(TreeNode cur) {
        if (cur == null) return;

        if (prev == null) {
            head = cur;
        } else {
            prev.right = cur;
        }

        cur.left = prev;    // 不可行，left改变了执行链路
        prev = cur;

        dfs(cur.left);  // !!!
        dfs(cur.right);
    }

    // 2.递归，可用用栈解决
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        // 逆序遍历
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,5,3,4,#,6,");

        L114 l = new L114();
        l.flatten(root);
        TreeUtil.show(root);
    }
}
