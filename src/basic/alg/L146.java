package basic.alg;


import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存机制
 * 使用时(添加/删除)，将节点添加至尾部，删除头部的元素
 *
 * 1.利用内置的LinkedHashMap = (DoubleList + HashMap)
 * a. 判断是否包含，若超出则删除
 * b. makeRecently() 重新添加
 *
 * 2. 自己实现LinkedHashMap
 * addLast()
 * removeFirst() -> remove()            head -> x -> tail
 */
public class L146 {
    private int cap;
    private LinkedHashMap<Integer, Integer> cache;

    public L146(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
             return -1;
        }

        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        // &&& 先判断是否存在
        if (cache.containsKey(key)) {
            cache.remove(key);

            cache.put(key, value);
            makeRecently(key);
            return;
        }

        // 超出时，删除头部节点
        if (cache.size() >= cap) {
            var oldKey = cache.keySet().iterator().next();   // &&& key
            cache.remove(oldKey);
        }

        cache.put(key, value);
        return;
    }

    // 添加到尾部
    public void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);

        cache.put(key, val);    // 默认添加到尾部
    }

    public static void main(String[] args) {
        L146 lRUCache = new L146(10);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    }
}
