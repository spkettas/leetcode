package basic.bin;

/**
 * 二分查找
 *
 * 1. 标准型
 * 2. 左侧边界查找
 * 3. 右侧边界查找
 */
public class BinQuery {
    // 1.标准型
    public static int binQuery(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;

        while (left <= right) { // &&&
            // + 优先级大于 >>>
            //int mid = left + ((right - left) >>> 1);
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return mid;     // mid闭区间
            } else if (a[mid] > target) {
                right = mid - 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 2.左边界
    public static int binLeftQuery(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                right = mid;
            } else if (a[mid] > target) {
                right = mid;    // 闭
            } else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return left;
    }

    // 3.右边界
    public static int binRightQuery(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid;    // 闭
            } else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static void main(String[] args) {
        // normal
        int[] a1 = {2, 8, 10, 18, 25, 49};
        int idx = BinQuery.binQuery(a1, 10);
        System.out.println("normal idx: " + idx);

        // left 不存在时不会返回-1
        int[] a2 = {2, 8, 10, 10, 10, 49};
        idx = BinQuery.binLeftQuery(a2, 10);
        System.out.println("left idx: " + idx);

        // right 不存在时不会返回-1
        int[] a3 = {2, 8, 10, 10, 10, 49};
        idx = BinQuery.binRightQuery(a3, 10);
        System.out.println("right idx: " + idx);
    }
}
