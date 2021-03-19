/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 */
#include "../util/myprint.h"

vector<string> res;

// &&& &track &used
void backtrace(string s, string& track, vector<bool> &used) {
    if (track.size() == s.size()) {
        res.push_back(track);
        return;
    }

    // &&& i=0
    for (int i=0; i<s.size(); i++) {
        // &&& i>0
        if (used[i]
            || (i > 0 && s[i] == s[i-1] && used[i-1]))  continue;

        track.push_back(s[i]);
        used[i] = true;

        backtrace(s, track, used);

        track.pop_back();
        used[i] = false;
    }
}

vector<string> permutation(string s) {
    if (s.size() == 0)  return {};

    string track = "";  // java中没有c++ string好用
    vector<bool> used(s.size());

    sort(s.begin(), s.end());

    backtrace(s, track, used);
    return res;
}

int main(int argc, char **argv)
{
    auto res = permutation("aac");
    showS(res);
    return 0;
}