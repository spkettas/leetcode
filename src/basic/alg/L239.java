package basic.alg;

import util.MyPrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口最大值
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 1.单调队列，单调递增
 * 动态维持平衡，队头总是最大值。
 */
public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }

        MQueue q = new MQueue();   // 单调队列
        List<Integer> list = new ArrayList<>(); // res

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                q.push(nums[i]);
            } else {
                q.push(nums[i]);
                list.add(q.max());

                // 移除队头数据
                q.pop(nums[i - k + 1]);
            }
        }

        int n = list.size();
        int[] res = new int[n];

        // copy
        for (int i=0; i<n; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        L239 l = new L239();
        var res = l.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        MyPrint.show(res);
    }
}

/**
 * 单调队列; 小的元素都被弹出，队头元素最大
 */
class MQueue {
    private LinkedList<Integer> queue;

    public MQueue() {
        queue = new LinkedList<>();
    }

    public void push(int n) {
        // 5 -> 4 -> 3
        // 前面比其小的都删除，数组递减. 与单调栈逻辑类似
        while (!queue.isEmpty() && queue.getLast() < n) {   // &&& <
            queue.pollLast();
        }

        queue.addLast(n);
    }

    public void pop(int n) {
        if (n == queue.getFirst()) {
            queue.pollFirst();
        }
    }

    public int max() {
        return queue.getFirst();
    }
}