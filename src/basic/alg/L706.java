package basic.alg;

import java.util.LinkedList;

/**
 *
 */
public class L706 {
    private static int BASE = 1023;
    private LinkedList<Pair> buckets[];

    public L706() {
        buckets = new LinkedList[BASE];

        for (int i=0; i<BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int k = hash(key);
        var list = buckets[k].iterator();
        while (list.hasNext()) {
            var cur = list.next();
            if (cur.key == k) {
                cur.val = value;
                return;
            }
        }

        buckets[k].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int k = hash(key);
        var list = buckets[k].iterator();
        while (list.hasNext()) {
            var cur = list.next();
            if (cur.key == k) {
                return cur.val;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int k = hash(key);
        var list = buckets[k].iterator();
        while (list.hasNext()) {
            var cur = list.next();
            if (cur.key == k) {
                buckets[k].remove(cur);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        L706 l = new L706();
        l.put(20, 21);
    }
}


class Pair {
    public int key;
    public int val;

    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}