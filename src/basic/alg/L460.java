package basic.alg;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU 缓存，最少使用次数
 * <p>
 * 1.准备三个map
 */
public class L460 {
    private Map<Integer, Integer> keyToVal;     // key - val
    private Map<Integer, Integer> keyToFreq;     // key - freq
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;     // freq - keys
    private int cap;
    private int minFreq;

    public L460(int cap) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = cap;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        // &&&
        if (this.cap <= 0) return;

        if (keyToVal.containsKey(key)) {
            increaseFreq(key);
            keyToVal.put(key, value);
            return;
        }

        if (cap <= keyToVal.size()) {
            removeMinFreq();
        }

        // Add
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        // 妙
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());  // &&& putIfAbsent
        freqToKeys.get(1).add(key);

        // 新插入
        this.minFreq = 1;
        return;
    }

    // 降低频次
    public void removeMinFreq() {
        LinkedHashSet<Integer> minSet = freqToKeys.get(minFreq);

        int deleteKey = minSet.iterator().next();   // 首个元素
        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
        minSet.remove(deleteKey);

        if (minSet.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
    }

    // 增加频次
    public void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);

        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);

        LinkedHashSet<Integer> minSet = freqToKeys.get(oldFreq);
        minSet.remove(key);
        if (minSet.isEmpty()) {
            freqToKeys.remove(oldFreq);
            //this.minFreq = newFreq;     // 更新逻辑不正确，不一定是最小min

            if (oldFreq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    public static void main(String[] args) {
        L460 l = new L460(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));   // 1
        l.put(3, 3);
        System.out.println(l.get(2)); // -1
    }
}
