package tree.prop;


/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 1.中序遍历
 */
public class O36 {
    private Node prev, head;

    public void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);

        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }

        root.left = prev;
        prev = root;    // 前移

        dfs(root.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        dfs(root);

        // head修正
        prev.right = head;
        head.left = prev;

        return head;
    }

    public static void main(String[] args) {

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

