package tree.traver;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 1. 递归
 * 2. 迭代法，子节点逆序推到栈中
 */
public class L589 {
    private List<Integer> res;

    public void dfs(Node root) {
        if (root == null) return;

        // 放在前面
        res.add(root.val);

        for (Node p : root.children) {
            dfs(p);
        }
    }

    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)  return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);

            // 逆转 -> 反反得正
            Collections.reverse(cur.children);
            for (Node p : cur.children) {
                stack.push(p);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L589 l = new L589();

    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

