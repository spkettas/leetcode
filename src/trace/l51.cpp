/**
 * 51. N 皇后
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 1. 标准回溯框架，结束条件最后一行放子
 */

#include "../util/myprint.h"

vector<vector<string>> res;

/**
 * board[row][col] 是否能放皇后
 * 其它的row还没放到，终止条件为row
 */
bool validQueue(vector<string> &board, int row, int col) {
    int m = board.size();

    // 横不写(包含在斜线了)
    // 竖
    for (int i=0; i<row; i++) {
        if (board[i][col] == 'Q')   return false;
    }

    // 左上方，单循环，且排除自身
    /*
    for (int i=row; i>=0; i--) {
        for (int j=col; j>=0; j--) {
            if (board[i][j] == 'Q')  return false;
        }
    }
    */
    // &&& 单循环
    for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q')  return false;
    }

    // 右上方，单循环，且排除自身
    /*
    for (int i=row; i>=0; i--) {
        for (int j=col; j<n; j++) {
            if (board[i][j] == 'Q')  return false;
        }
    }
    */
    for (int i=row-1, j=col+1; i>=0 && j<m; i--, j++) {
            if (board[i][j] == 'Q')  return false;
    }

    return true;
}

void backtrace(vector<string> &board, int row) {
    // 放满了
    if (row == board.size()) {
        res.push_back(board);
        return;
    }

    // &&& start -> board[row]
    int n = board[row].size();
    for (int j=0; j<n; j++) {
        if (!validQueue(board, row, j)) {
            continue;
        }

        board[row][j] = 'Q';
        backtrace(board, row + 1);
        board[row][j] = '.';
    }
}

vector<vector<string>> solveNQueens(int n) {
    // &&& board
    vector<string> board(n, string(n, '.'));
    backtrace(board, 0);

    return res;
}


int main(int argc, char **argv) {
    auto res = solveNQueens(4);
    showVS(res);

    return 0;
}
