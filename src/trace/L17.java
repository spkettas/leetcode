package trace;


import util.MyPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class L17 {
    private List<String> res;
    private Map<Character, String> map;

    public void backtrace(String digits, int index, StringBuilder track) {
        if (index == digits.length()) {
            res.add(track.toString());
            return;
        }

        // map
        char ch = digits.charAt(index); // &&& index
        String word = map.get(ch);

        for (int i=0; i<word.length(); i++) {
            track.append(word.charAt(i));   // 各选一个
            backtrace(digits, index + 1, track);
            track.deleteCharAt(index);  // &&& index
        }
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0)  return res;

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder track = new StringBuilder();
        backtrace(digits, 0, track);
        return res;
    }

    public static void main(String[] args) {
        L17 l = new L17();
        var res = l.letterCombinations("23");
        MyPrint.showStrs(res);
    }
}
