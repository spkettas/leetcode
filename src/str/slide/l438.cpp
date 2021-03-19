/**
 *
 * 找到字符串中所有字母异位词
 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]
 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 * 1. 与l567题型一致，只是需要返回索引. (right - left > p.size())
 * if (need.count(d) > 0)  是否存在key
 *
 */
#include <stdio.h>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;


vector<int> findAnagrams(string s, string t) {
    unordered_map<char,int> need, window;

    for (auto c : t) need[c]++;

    int right = 0, left = 0;
    int start = 0, end = 0;
    int valid = 0;

    vector<int> res;
    while (right < s.size()) {
        char c = s[right];
        right++;

        // count()判断是否存在
        if (need.count(c) > 0) {
            window[c]++;

            if (window[c] == need[c]) {
                valid++;
            }
        }

        // &&& >=
        while (right - left >= t.size()) {
            if (valid == need.size()) {
                res.push_back(left);    // left
            }

            char d = s[left];
            left++;

            if (need.count(d) > 0) {
                if (need[d] == window[d]) {
                    valid--;
                }

                window[d]--;
            }
        }
    }

    return res;
}

int main(int argc, char **argv) {
    auto res = findAnagrams("cbaebabacd", "abc");
    for (auto r : res) {
        printf("%d\n", r);  // [0, 6]
    }

    return 0;
}

