package trace.md;

/**
 * 79. 单词搜索
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 1. dfs，与岛屿数量题类似，二维数组内搜索。
 * a. 添加额外参数index 描述已处理的单词索引
 * b. 添加返回值
 */
public class L79 {
    public boolean inArea(char[][] board, int i, int j) {
        int nr = board.length;
        int nc = board[0].length;
        return i >= 0 && i < nr && j >= 0 && j < nc;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (!inArea(board, i, j)) return false;

        if (board[i][j] != word.charAt(index)) return false;

        // 搜索完成
        if (index == word.length() - 1) return true;

        char tmp = board[i][j];
        board[i][j] = '.';      // 标记

        boolean res = dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i, j - 1, index + 1)
                || dfs(board, word, i, j + 1, index + 1);

        board[i][j] = tmp;      // 恢复
        return res;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // &&& 搜索index
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        L79 l = new L79();
        var flag = l.exist(board, "ABCCED");
        System.out.println(flag);
    }
}
