package trace;

import util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 1. dfs，非回溯法。 left<right
 */
public class L22 {
    private List<String> res;

    public void dfs(int n, int left, int right, String track) {
        if (left == n && right == n) {
            res.add(track);
            return;
        }

        // &&&
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(n, left + 1, right, track + "(");
        }

        if (right < n) {
            dfs(n, left, right + 1, track + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        dfs(n, 0, 0, "");
        return res;
    }

    public static void main(String[] args) {
        L22 l = new L22();
        var res = l.generateParenthesis(3);
        MyPrint.showStrs(res);
    }
}
