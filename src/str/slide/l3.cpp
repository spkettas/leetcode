/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 解题技巧：
 * 1.滑动窗口，没有need变量，更简单了. (window[c] > 1).  此时最长默认指连续子串
 */
#include <stdio.h>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;


int lengthOfLongestSubstring(string s) {
    unordered_map<char,int> window;

    int left = 0, right = 0;
    int res = 0;

    while (right < s.size()) {
        char c = s[right];
        right++;

        // update
        window[c]++;

        // &&& > 1
        while (window[c] > 1) {
        //while (window.count(c) > 1) {
            char d = s[left];
            left++;

            window[d]--;
        }

        // 此时已无重复
        res = max(res, right - left);
    }

    return res;
}


int main(int argc, char **argv) {
    auto res = lengthOfLongestSubstring("aabab");
    printf("%d\n", res);

    return 0;
}