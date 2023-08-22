/**
 * c++工具库，提供打印
 *
 */
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <string>


using namespace std;

vector<vector<int>> TwoSumTarget(vector<int>& nums, int start, int target);
vector<vector<int>> nSumTarget(vector<int>& nums, int n, int start, int target);

int partition(vector<int>&a, int lo, int hi);
void show(std::vector<int> &v);
void showS(std::vector<string> &v);
void showV(vector<vector<int>> &v);
void showVS(vector<vector<int>> &v);


int partition(vector<int>&a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int base = a[lo];

    while (1) {
        // &&& ++i
        while (++i <= hi && a[i] < base);

        // &&& --j
        while (--j >= lo && a[j] > base);

        if (i >= j) {
            break;
        }

        std::swap(a[i], a[j]);
    }

    std::swap(a[lo], a[j]);
    return j;
}

void show(std::vector<int> &v) {
    for (const auto &e : v) {
        printf("%d\t", e);
    }

    printf("\n");
}

void showS(std::vector<string> &v) {
    for (const auto &e : v) {
        printf("%s\t", e.c_str());
    }

    printf("\n");
}

void showV(vector<vector<int>> &v) {
    printf("[\n");
    for (int i=0; i<v.size(); i++) {
        auto es = v[i];

        printf("[");
        for (auto e : es) {
            printf("%d\t", e);
        }
        printf("]\n");
    }

    printf("]\n");
}

void showVS(vector<vector<string>> &v) {
    printf("[\n");
    for (int i=0; i<v.size(); i++) {
        auto es = v[i];

        printf("[");
        for (auto e : es) {
            printf("%s ", e.c_str());
        }
        printf("]\n");
    }

    printf("]\n");
}

/**
 * 二数之和
 * nums = [2,7,11,15], target = 9
 *
 */
vector<vector<int>> TwoSumTarget(vector<int>& nums, int start, int target) {
    vector<vector<int>> res;

    // 排序
    sort(nums.begin(), nums.end());

    int lo = start, hi = nums.size() - 1;   // &&& start

    // 二分搜索
    while (lo  < hi) {
        int left = nums[lo], right = nums[hi];
        int sum = left + right;

        if (sum > target) {
            // 去重
            while (lo < hi && nums[hi] == right)  hi--;
        } else if (sum < target) {
            // 去重
            while (lo < hi && nums[lo] == left)  lo++;
        } else {
            res.push_back({left, right});

            // &&& 去重
            while (lo < hi && nums[hi] == right)  hi--;     // &&& lo < hi
            while (lo < hi && nums[lo] == left)  lo++;
        }
    }

    return res;
}

/**
 * nSum nSum之和
 * @param n  几数之和
 * @param start start pos
 */
vector<vector<int>> nSumTarget(vector<int>& nums, int n, int start, int target)
{
    int sz = nums.size();
    vector<vector<int>> res;

    // base case
    if (n < 2 || sz < n)  return res;

    if (n == 2) {   // 两数和
        int lo = start, hi = sz - 1;  // &&& sz
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;

            if (sum < target) {
                while(lo < hi && nums[lo] == left)  lo++;
            } else if (sum > target) {
                while(lo < hi && nums[hi] == right)  hi--;
            } else {
                res.push_back({left, right});

                while(lo < hi && nums[lo] == left)  lo++;
                while(lo < hi && nums[hi] == right)  hi--;
            }
            // return res;
        }
    } else {    // n数和
        // start
        for (int i=start; i<sz; i++) {
            // &&& n-1, i+1
            vector<vector<int>> nTuple = nSumTarget(nums, n-1, i+1, target - nums[i]);

            for (auto &t : nTuple) {
                t.push_back(nums[i]);

                res.push_back(t);
            }

            // &&&
            while (i < sz - 1 && nums[i] == nums[i+1]) i++;
        }
    }

    return res;
}
