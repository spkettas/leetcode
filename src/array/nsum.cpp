/**
 * N数之和
 * 1. 两数之和
 * 15. 三数之和, a+b+c=0, 注意：答案中不可以包含重复的三元组。
 * 18. 四数之和，a+b+c+d=0, 注意：答案中不可以包含重复的三元组。
 *
 * 1. 前缀和
 * 排序后二分搜索；结果不能有重复
 * 15. 3Sum，调用2sum()
 * 18. nSum，递归nSum()
 */

#include <algorithm>
#include <stdio.h>
#include <vector>
#include <unordered_map>
#include "../util/myprint.h"

using namespace std;

/**
 * 二数之和索引，不能改变数组。引入map
 */
vector<int> twoSum(vector<int>& nums, int target) {
    // 元素 -> 索引
    unordered_map<int,int> map;

    // init
    for (int i=0; i<nums.size(); i++) {
        map.insert({nums[i], i});
    }

    for (int i=0; i<nums.size(); i++) {
        int other = target - nums[i];

        // &&& !=i
        if (map.find(other) != map.end() && map[other] != i) {
            return {i, map[other]};
        }
    }

    return {};
}

/**
 * 2Sum 之和，需要先排序
 */
vector<vector<int>> twoSumTarget(vector<int>& nums, int target) {
    vector<vector<int>> res;

    // 排序
    sort(nums.begin(), nums.end());

    int lo = 0, hi = nums.size() - 1; // &&& =0

    // 二分搜索
    while (lo  < hi) {
        int left = nums[lo], right = nums[hi];      // &&& 赋值
        int sum = left + right;

        if (sum > target) {
            // 去重
            while (lo < hi && nums[hi] == right)  hi--;     // &&& l<r
        } else if (sum < target) {
            // 去重
            while (lo < hi && nums[lo] == left)  lo++;
        } else {
            res.push_back({left, right});

            // &&& 去重
            while (lo < hi && nums[hi] == right)  hi--;
            while (lo < hi && nums[lo] == left)  lo++;
        }
    }

    return res;
}


/**
 * 三数之和，call twoSumTarget
 */
vector<vector<int>> threeSumTarget(vector<int>& nums, int target) {
    vector<vector<int>> res;
    int n = nums.size();

    if (n == 0) {
        return res;
    }

    sort(nums.begin(), nums.end());

    for (int i=0; i<n; i++) {
        auto tuples = TwoSumTarget(nums, i+1, target - nums[i]);   // &&&剩余两数之和

        // 补全
        for (auto &tuple : tuples) {
            tuple.push_back(nums[i]);

            res.push_back(tuple);
        }

        // 去重
        while (i < n-1 && nums[i] == nums[i+1]) i++;
    }

    return res;
}


vector<vector<int>> threeSumTarget1(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());

    return nSumTarget(nums, 3, 0, target);
}

int main(int argc, char **argv) {
    // 2Sum
    vector<int> v0{3, 2, 4};
    auto ret = twoSum(v0, 6);
    show(ret);

    // 2Sum
    vector<int> v{1, 1, 1, 2, 2, 3, 3};
    auto res = twoSumTarget(v, 4);
    showV(res);

    // 3Sum
    vector<int> v1{-1, 0, 1, 2, -1, -4};
    res = threeSumTarget(v1, 0);
    showV(res);

    // 3Sum
    res = threeSumTarget1(v1, 0);
    showV(res);

    return 0;
}