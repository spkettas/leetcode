package array;


import util.MyPrint;

/**
 * 48. 旋转图像，转动90度
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 1. 辅助数组  m[row][col] -> m[col][n-row-1]
 * 2. 原地翻转
 */
public class L48 {
    // 1.辅助数组
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;

        int n = matrix[0].length;
        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                copy[j][n - i - 1] = matrix[i][j];
            }
        }

        // update
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }

    // 2.原地翻转
    public void rotate1(int[][] matrix) {

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        L48 l = new L48();
        l.rotate(matrix);
        MyPrint.show(matrix);
    }
}
