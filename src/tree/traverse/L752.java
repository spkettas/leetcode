package tree.traverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * <p>
 * 1. 图最短距离，按层遍历
 * 4盘转轮，每次有8种组合，抽象成图问题，最短距离
 * 遍历矩阵：size * 4
 * 注：按层遍历就是bfs应用之一
 */
public class L752 {
    // 向上转动
    public String up(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }

        return new String(ch);
    }

    // 向下转动
    public String down(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }

        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() < 4) {
            return -1;
        }

        Set<String> deads = new TreeSet<>();    // 黑名单
        Set<String> visited = new TreeSet<>();  // 是否访问

        for (var s : deadends) {
            deads.add(s);
        }

        int depth = 0;  // &&&
        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        while (!q.isEmpty()) {
            int cnt = q.size();

            // 节点向四周扩散
            for (int i = 0; i < cnt; ++i) {
                String cur = q.poll();

                // 是否为黑名单
                if (deads.contains(cur)) {
                    continue;   // 此路不通
                }

                // 是否到达终点
                if (cur.equals(target)) {    // &&&
                    return depth;
                }

                // n = 4
                for (int j = 0; j < 4; j++) {   // 4个轮子
                    // left -> up
                    String sup = up(cur, j);
                    if (!visited.contains(sup)) {
                        q.offer(sup);
                        visited.add(sup);
                    }

                    // right -> down
                    String sdown = down(cur, j);
                    if (!visited.contains(sdown)) {
                        q.offer(sdown);
                        visited.add(sdown);
                    }
                }
            }

            depth++;
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};

        L752 l = new L752();
        int depth = l.openLock(deadends, "0202");
        System.out.println("lock: " + depth);
    }
}
