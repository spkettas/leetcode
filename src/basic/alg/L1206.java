package basic.alg;


/**
 * 1206. 设计跳表
 * 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 1.add()一个节点，随机一个层数
 * https://leetcode-cn.com/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
 */
public class L1206 {
    private static final int DEFAULT_LEVEL = 32;
    private static final double DEFAULT_FACTOR = 0.25;
    private Node head;      // 头节点
    private int curLevel;   // 当前层

    public L1206() {
        this.curLevel = 1;
        this.head = new Node(null, DEFAULT_LEVEL);
    }

    public boolean search(int target) {
        Node node = head;

        // 当前层往下面找
        for (int i=curLevel-1; i>=0; i--) {
            node = findClosest(node, i, target);

            if (node.next[i] != null && node.next[i].value == target) {
                return true;
            }
        }

        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node updateNode = head;     // 指向头

        for (int i=curLevel-1; i>=0; i--) {
            updateNode = findClosest(updateNode, i, num);

            // 每层都插入新值
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node tmp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = tmp;
                }
            }
        }

        // 新增了一个最大层，维护head节点
        if (level > curLevel) {
            for (int i=curLevel; i<level; i++) {
                head.next[i] = newNode;
            }

            curLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node node = head;

        for (int i=curLevel-1; i>=0; i--) {
            node = findClosest(node, i, num);

            if (node.next[i] != null && node.next[i].value == num) {
                node.next[i] = node.next[i].next[i];
                flag = true;
                continue;
            }
        }

        return flag;
    }

    // 随机层数
    public int randomLevel() {
        int level = 1;

        while (Math.random() < DEFAULT_FACTOR && level < DEFAULT_LEVEL) {
            level++;
        }

        return level;
    }

    // 查找最近的>=value的节点
    public Node findClosest(Node node, int levelIndex ,int value) {
        while ((node.next[levelIndex]) != null
                && node.next[levelIndex].value < value) {
            node = node.next[levelIndex];
        }

        return node;
    }

    public static void main(String[] args) {
        L1206 l = new L1206();
        l.add(12);
        l.add(28);
        var flag = l.search(27);
        System.out.println(flag);

        flag = l.search(28);
        System.out.println(flag);
    }
}

class Node {
    Integer value;
    Node[] next;     // 每一层下个节点

    public Node(Integer value, int size) {
        this.value = value;
        this.next = new Node[size];
    }

    public String toString() {
        return String.valueOf(value);
    }
}