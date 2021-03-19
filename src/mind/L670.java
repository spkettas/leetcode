package mind;


/**
 *
 * 670. 最大交换
 * 给定一个非负整数，你至多可以<交换一次>数字中的任意两位。返回你能得到的最大值。
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 *
 * 1.贪心算法，只需要交换最大值至首位即可
 */
public class L670 {
    public void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int maximumSwap(int num) {
        if (num == 0) return 0;

        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        int len = arr.length;

        int[] last = new int[10];   // 10个数字
        for (int i=0; i<len; i++) {
            last[arr[i] - '0'] = i;  // 记录数组最大值出现位置
        }

        // 0位与后面最大位交换
        for (int i=0; i<len - 1; i++) {
            for (char d=9; d>arr[i] - '0'; d--) {
                if (last[d] > i) {  // 从最大位开始遍历
                    swap(arr, i, last[d]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        L670 l = new L670();
        var res = l.maximumSwap(2736);
        System.out.println(res);
    }
}
