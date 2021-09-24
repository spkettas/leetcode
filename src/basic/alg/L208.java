package basic.alg;

import com.sun.source.tree.AssertTree;
import str.mind.L20;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 1. 经典
 * { child, isEnd }
 */
public class L208 {
    public static void main(String[] args) {
        Trie l = new Trie();
        l.insert("apple");

        System.out.println(l.startsWith("hk")); // false
        System.out.println(l.startsWith("app")); // true
        System.out.println(l.search("apple")); // true
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];    // 只能填充小写字母
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}
