/**
 * 567.字符串的排列
 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 1.滑动窗口
 * 难点：窗口更新，(right - left > t.size())
 */

#include <stdio.h>
#include <string>
#include <unordered_map>

using namespace std;

/**
 * 检测s2是否包含s1的排列（随机组合）
 *
 */
bool checkInclusion(string s1, string s2) {
    // need 实际窗口计数，window 当前窗口计算
    unordered_map<char,int> need, window;

    for (auto c : s1) need[c]++;

    int left = 0, right = 0;
    int valid = 0;

    while (right < s2.size()) {
        char c = s2[right];
        right++;

        // update
        if (need.count(c) > 0) {
            window[c]++;

            if (window[c] == need[c]) {
                valid++;
            }
        }

       // 超出s1大小，需要收缩了
       while (right - left >= s1.size()) {
            // &&&
            if (valid == need.size())  return true;

            char d = s2[left];
            left++;

            // update
            if (need.count(d) > 0) {
                if (window[d] == need[d]) {
                    valid--;
                }

                window[d]--;
            }
       }
    }

    return false;
}

int main(int argc, char **argv) {
    string s1 = "oow";
    string s2 = "helloworld";

    auto flag = checkInclusion(s1, s2);
    printf("flag=%d\n", flag);
    return 0;
}
