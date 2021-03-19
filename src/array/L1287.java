package array;


/**
 * 1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *
 * 1. 线性遍历计数
 */
public class L1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        else if (n == 1) return arr[0];

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;

                if (cnt * 4 > n) {
                    return arr[i];
                }
            } else {
                cnt = 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        L1287 l = new L1287();
        var res = l.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10});
        System.out.println(res);
    }
}
