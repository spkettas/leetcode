package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树工具库
 */
public class TreeUtil {
    private static String SEP = ",";
    private static String NULL = "#";

    public static void show(TreeNode root, int type) {
        if (root == null) return;
        if (type == 1) // 前
            System.out.print(root.val + " ");
        show(root.left, type);
        if (type == 2)  // 中
            System.out.print(root.val + " ");
        show(root.right, type);
        if (type == 3) // 后
            System.out.print(root.val + " ");
    }

    public static void show(TreeNode root) {
        System.out.print("tree: ");
        if (root == null) {
            System.out.print("  null");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.print("\t" + cur.val);

            if (cur.left != null) {
                q.offer(cur.left);
            }

            if (cur.right != null) {
                q.offer(cur.right);
            }
        }

        System.out.println();
    }

    /**
     * 层序遍历  序列化树
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(node.val).append(SEP);
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    /**
     * 反序列化
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(SEP);

        // 反向，先构建根节点
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0])); // 根节点

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // while (!q.isEmpty()) {
        for (int i = 1; i < nodes.length; ) {   // &&&
            TreeNode parent = q.poll();     // &&&

            // left
            String left = nodes[i++];
            if (!NULL.equals(left)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null; // &&&
            }

            // right
            String right = nodes[i++];
            if (!NULL.equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }

        return root;
    }

    /**
     * 是否存在节点 -> 框架
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }

    /**
     * 二叉树插入一个数 -> 框架
     */
    public TreeNode insert2BST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            root.right = insert2BST(root.right, val);   // right + right
            return root;
        } else {
            root.left = insert2BST(root.left, val);
            return root;
        }
    }

    /**
     * 二叉树节点数目；分析是否为 满二叉树 or 普通二叉树
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int lcnt = 0, rcnt = 0;
        TreeNode p = root;

        // left
        while (p != null) {
            p = p.left;
            lcnt++;
        }

        p = root;

        // right
        while (p != null) {
            p = p.right;
            rcnt++;
        }

        // 满二叉树
        if (lcnt == rcnt) {
            return (int)Math.pow(2, lcnt) - 1;
        }

        // 普通二叉树
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeUtil u = new TreeUtil();
        String data = u.serialize(root);
        System.out.println("serial: " + data);

        TreeNode head = u.deserialize(data);
        TreeUtil.show(head);

        ///
        root = deserialize("3,9,20,1,8,15,7,");
        TreeUtil.show(root, 3);
        System.out.println();
    }
}
