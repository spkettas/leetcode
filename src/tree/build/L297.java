package tree.build;

import util.TreeNode;
import util.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树序列化
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 1. 递归法，将大问题拆分为小问题，前序遍历较简单
 * StringBuilder vs StringBuffer
 */
public class L297 {
    private static String SEP = ",";
    private static String NULL = "#";

    public void serial(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        serial(root.left, sb);
        serial(root.right, sb);
    }

    /**
     * 序列化，直接用递归解决
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serial(root, sb);
        return sb.toString();
    }

    public TreeNode deserial(LinkedList<String> params) {
        if (params.size() == 0) {
            return null;
        }

        // remove
        String val = params.removeFirst();

        // null
        if (NULL.equals(val)) {
            return null;
        }

        // 前序
        TreeNode cur = new TreeNode(Integer.parseInt(val));
        cur.left = deserial(params);
        cur.right = deserial(params);

        return cur;
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] params = data.split(SEP);
        return deserial(new LinkedList<String>(Arrays.asList(params)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        L297 l = new L297();
        String data = l.serialize(root);
        System.out.println("serial: " + data);

        TreeNode head = l.deserialize(data);
        TreeUtil.show(head);
    }
}
