package trace.md;

import util.MyPrint;

/**
 * 顺时针打印矩阵
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 1.按层遍历；难点：边界条件过于复杂，<= < >= >，元素用过就不要=
 *
 * a.四个边界条件，各标量不变
 * [top,left] -> [top,right]            top
 * [top,right] -> [bottom, right]       right
 * [bottom,right-1] -> [bottom,left]    bottom
 * [bottom,left] -> [top+1,left]        left
 *
 * b. 两个对角收缩至下一层
 * [top,left]
 * [bottom,right]
 */
public class O29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] order = new int[m * n];
        int top = 0, left = 0, bottom = m - 1, right = n -1;
        int idx = 0;

        // 从原点出发 &&& <=
        while (top <= bottom && left <= right) {
            // &&& <=
            for (int i=left; i<=right; i++) {
                order[idx++] = matrix[top][i];
            }

            // 下一个
            for (int i=top+1; i<=bottom; i++) {
                order[idx++] = matrix[i][right];
            }

            // &&& <
            if (top < bottom && left < right) {
                for (int i=right-1; i>=left; i--) {
                    order[idx++] = matrix[bottom][i];
                }

                for (int i=bottom-1; i>top; i--) {
                    order[idx++] = matrix[i][left];
                }
            }

            top++;
            left++;
            bottom--;
            right--;
        }

        return order;
    }

    public static void main(String[] args) {
        int[][] matrix =  {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        O29 o = new O29();
        var res = o.spiralOrder(matrix);
        MyPrint.show(res);
    }
}
