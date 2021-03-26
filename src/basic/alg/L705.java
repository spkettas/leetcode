package basic.alg;

import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）
 *
 * 1.开链法
 */
public class L705 {
    private static int BASE = 1023;
    private LinkedList<Integer>[] data;     // 链表数组 - bucket

    public L705() {
        data = new LinkedList[BASE];
        for (int i=0; i<BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int h = hash(key);
        var list = data[h].iterator();

        while (list.hasNext()) {
            var k = list.next();
            if (k == key) return;
        }

        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        var list = data[h].iterator();

        while (list.hasNext()) {
            var k = list.next();
            if (k == key) {
                data[h].remove(k);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        var list = data[h].iterator();

        while (list.hasNext()) {
            var k = list.next();
            if (k == key) {
                return true;
            }
        }

        return false;
    }

    public int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        L705 l = new L705();
        l.add(20);
    }
}
