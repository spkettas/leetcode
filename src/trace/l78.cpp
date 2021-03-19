/**
 * 子集
 */
#include <stdio.h>
#include <vector>
#include "../util/myprint.h"

using namespace std;


vector<vector<int>> subsets(vector<int>& nums) {
    if (nums.empty()) return {{}};

    // last
    int last = nums.back();
    nums.pop_back();

    vector<vector<int>> res = subsets(nums);
    int size = res.size();  // &&& 保留初始长度
    for (int i=0; i<size; i++) {
        res.push_back(res[i]);  // 叠加
        res.back().push_back(last);
    }

    return res;
}

int main(int argc, char **argv) {
    vector<int> nums{1, 2, 3};
    auto res = subsets(nums);
    showV(res);

    return 0;
}