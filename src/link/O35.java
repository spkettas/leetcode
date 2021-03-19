package link;


import java.util.*;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 1. 图的遍历
 * 1.dfs 递归
 * 2.bfs 层序遍历
 */
public class O35 {
    private Map<Node, Node> visited;

    public Node dfs(Node cur) {
        if (cur == null) return null;

        if (visited.containsKey(cur))  return visited.get(cur);

        Node copy = new Node(cur.val);
        copy.next = dfs(cur.next);
        copy.random = dfs(cur.random);

        return copy;
    }

    // dfs
    public Node copyRandomList1(Node head) {
        visited = new HashMap<>();
        return dfs(head);
    }

    // 2.bfs
    public Node copyRandomList(Node head) {
        if (head == null)  return null;

        Node copy = new Node(head.val);

        // old -> copy
        Map<Node, Node> visited = new HashMap<>();
        LinkedList<Node> q = new LinkedList<>();
        q.offer(head);
        visited.put(head, copy);    // &&& copy

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // &&& contains()
            if (cur.next != null && !visited.containsKey(cur.next)) {
                visited.put(cur.next, new Node(cur.next.val)); // &&& new Node

                q.offer(cur.next);
            }

            if (cur.random != null && visited.containsKey(cur.random)) {
                visited.put(cur.random, new Node(cur.random.val));

                q.offer(cur.random);
            }

            visited.get(cur).next = visited.get(cur.next);  // &&& link
            visited.get(cur).random = visited.get(cur.random);
        }

        return copy;
    }

    public static void main(String[] args) {

    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

