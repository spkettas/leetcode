package array;


/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 1. 二分查找；选择较小的row/col，然后水平、垂直二分
 * 2. 指针移动；左下角
 */
public class L240 {
    public boolean binarySearch(int[][] matrix, int target, int start, boolean bVertical) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = start, r = bVertical ? n - 1 : m - 1;

        while (l <= r) {
            int mid = (l + r ) / 2;

            if (bVertical) {    // col
                if (matrix[start][mid] == target) {
                    return true;
                } else if (matrix[start][mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {    // row
              if (matrix[mid][start] == target) {
                  return true;
              } else if (matrix[mid][start] < target) {
                  l = mid + 1;
              } else {
                  r = mid - 1;
              }
            }
        }

        return false;
    }

    // 1.二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)  return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int sn = Math.min(m, n);
        for (int i=0; i<sn; i++) {
            boolean horizon = binarySearch(matrix, target, i, true);
            boolean vertical = binarySearch(matrix, target, i, false);

            if (horizon || vertical) {
                return true;
            }
        }

        return false;
    }

    /**
     * 2. 指针移动
     * 初始指针定位于左下角，然后向上向右查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;

        int n = matrix[0].length;
        int l = m - 1, r = 0;

        // &&& >=
        while (l >= 0 && r < n) {
            if (matrix[l][r] == target) {
                return true;
            } else if (matrix[l][r] > target) {
                l--;
            } else {
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        L240 l = new L240();
        var res = l.searchMatrix(matrix, 5);
        System.out.println(res);

        res = l.searchMatrix1(matrix, 5);
        System.out.println(res);
    }
}
