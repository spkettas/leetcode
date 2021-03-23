package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import util.MyPrint;

interface MyService {
    int op(int a, int b);
}

/**
 * java 类库测试
 * quick: main/sout
 */
public class Test {
    public static void basic() {
        int a = 2 >> 1;
        int b = 2 >>> 1;
        System.out.println(a + "\t" + b);

        int c = 0xab;
        int d = Integer.rotateLeft(c, 2);   // 左移
        a = 0;
    }

    // 测试tree
    public static void testTree() {
        MyService service = (a, b) -> a - b;

        // lambda
        TreeSet<Integer> pq = new TreeSet<>((a, b) -> {
            return b - a;
        });

        pq.add(7);
        pq.add(5);
        pq.add(9);
        System.out.println("last: " + pq.last());

        int a = 0xffffff1b;  // -229
        System.out.println(a);
    }

    // 测试list
    public static void testList() {
        // removeLast
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        MyPrint.show(list);
        list.remove(list.size() - 1);   // LinkedList:removeLast()
        MyPrint.show(list);     // 1 2

        // 
        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        ArrayList<Integer> es = new ArrayList<>();
        es.add(1);
        es.add(2);
        es.add(3);
        ls.add(es);     // 不用强转也行
        MyPrint.show(ls.get(0));    // 1 2 3

        HashMap<Integer, Integer> map = new HashMap<>();
        map.keySet();
        ConcurrentMap<Integer, Integer> m1 = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Integer> m2 = new CopyOnWriteArrayList<>();
        return;
    }

    public static void main(String[] args) {
        basic();
        testList();
        testTree();
    }
}