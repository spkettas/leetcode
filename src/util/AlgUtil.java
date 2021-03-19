package util;

/**
 * 算法工具库
 */
public class AlgUtil {
    // 交换数据
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
