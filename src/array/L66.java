package array;

/**
 * 数组加一操作
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 注意99 这种特殊用例
 */
public class L66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // 从尾数加
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            // 不用进位了
            if (digits[i] != 0) return digits;
        }

        // 99/999 这种情况
        digits = new int[digits.length + 1];
        digits[0] = 1;  // 高位置1，其它位默认置0
        return digits;
    }

    public static void main(String[] args) {
        L66 l = new L66();
        var a = l.plusOne(new int[]{1, 2, 3, 4});
        for (var p : a) {
            System.out.println(p);
        }
    }
}
