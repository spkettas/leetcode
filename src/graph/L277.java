package graph;

/**
 * 寻找网红
 * 所有人认识名人，名人不认识其它人
 *
 * 1.链表
 * 2.无需额外空间
 * https://mp.weixin.qq.com/s/hd06P3ASUAmA5apbAB1nIw
 */
public class L277 {
    // i认识j
    private boolean knows(int i, int j) {
        return false;
    }

    // 2. 优化类
    public int findCelebrity(int n) {
        int cand = 0;
        for (int other = 0; other < n; other++) {
            if (other == cand) continue;

            if (knows(cand, other) || !knows(other, cand)) {
                // 排除名人cand
                cand = other;
            } else {
                // 排除名人other
            }
        }

        // cand是排除后最终的结果，并不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (other == cand) continue;

            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }

        return cand;
    }

    public static void main(String[] args) {

    }
}
