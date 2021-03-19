package str.mind;

import util.MyPrint;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 1. 对单词排序，这样就能确定同一个分组了
 */
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] src = str.toCharArray();
            Arrays.sort(src);   // char[]

            String key = new String(src);

            // &&& new
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list); // update
        }

        // &&& new
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        L49 l = new L49();
        var res = l.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        MyPrint.showStr(res);
    }
}
