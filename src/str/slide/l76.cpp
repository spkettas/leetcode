/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
   注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

   输入：s = "ADOBECODEBANC", t = "ABC"
   输出："BANC"

 * 1.滑动窗口
 * need 实际窗口计数，window 当前窗口计算
 * 难点：窗口更新, (valid == need.size())
 */

#include <stdio.h>
#include <string>
#include <unordered_map>

using namespace std;

#define INT_MAX 0x7fffffff

/**
 * s中找到覆盖t的最小子串
 */
string minWindow(string s, string t) {
    if (s.size() == 0 || t.size() == 0) {
        return "";
    }

    // char -> cnt
    unordered_map<char,int> need, window;

    for (auto c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0;
    int start = 0, len = INT_MAX;

    while (right < s.size()) {
        // 右移扩大窗口
        char c = s[right];
        right++;

        // 命中
        if (need.count(c) > 0) {
            window[c]++;

            // 符合条件
            if (window[c] == need[c]) {
                valid++;
            }
        }

        // 准备收缩
        while (valid == need.size()) {
            // update
            if (right - left < len) {
                start = left;   // &&&
                len = right - left;
            }

            // 左移缩小窗口
            char d = s[left];
            left++;

            // &&& 同增/同减
            if (need.count(d) > 0) {
                if (need[d] == window[d]) {
                    valid--;
                }

                window[d]--;
            }
        }
    }

    return len == INT_MAX ? "" : s.substr(start, len);
}

int main(int argc, char **argv) {
    auto s = minWindow("ADOBECODEBANC", "ABC");
    printf("s: %s\n", s.c_str());   // BANC
    return 0;
}
