package basic.alg;

import com.sun.source.tree.AssertTree;
import str.mind.L20;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 1. 经典
 * { child, isEnd }
 */
public class L208 {
    private TrieNode root;

    public L208() {
        root = new TrieNode();
    }

    // 闭合点
    public void insert(String word) {
        if (word.length() == 0) return;

        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
               node.put(ch, new TrieNode());
            }

            node = node.get(ch);    // 链式查找
        }

        node.setEnd();  // &&&
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public TrieNode searchPrefix(String prefix) {
        if (prefix.length() == 0) return null;

        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }

        return node;
    }

    public static void main(String[] args) {
        L208 l = new L208();
        l.insert("apple");

        System.out.println(l.startsWith("hk")); // false
        System.out.println(l.startsWith("app")); // true
        System.out.println(l.search("apple")); // false
    }
}

// 单词节点
class TrieNode {
    private static final int N = 26;  // 限制只能存放小写字母
    private TrieNode[] child;
    private boolean isEnd;  // 结束标志

    public TrieNode() {
        child = new TrieNode[N];
        isEnd = false; // &&&
    }

    public boolean containsKey(char ch) {
        return child[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return child[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        child[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
