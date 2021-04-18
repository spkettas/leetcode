package array;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 1. 二分查找
 */
public class O11 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (n == 0)  return -1;

        int low = 0;
        int high = n - 1;
        while (low < high) {
            int pivot = low + (high - low)/2;

            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;  // 有重复
            }
        }

        return numbers[low];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};

        O11 o = new O11();
        var res = o.minArray(a);
        System.out.println(res);
    }
}
