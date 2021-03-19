package trace.md;

/**
 * 200. 岛屿数量
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","<1>","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 1. dfs遍历，二维数组类似树
 * a.上下左右四个方向
 * b.标记防重量遍历。0水 1岛屿 2已遍历
 *
 * 框架：
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
public class L200 {
    public boolean inArea(char[][]grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        return i>=0 && i < nr && j >=0 && j < nc;
    }

    public void dfs(char[][]grid, int i, int j) {
        if (!inArea(grid, i, j)) return;

        // 非岛屿
        if (grid[i][j] != '1')  return;

        grid[i][j] = '2';  // 标记已遍历，不用恢复

        // 上下左右
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    dfs(grid, i, j);    // &&& 此处回溯
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char grid[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        L200 l = new L200();
        var res = l.numIslands(grid);
        System.out.println(res);
    }
}
