/**
 * 最小k个数，海量数据搜索
 *
 * 1. 二叉堆：最大堆
 * 2. 快排法：部分排序
 */
#include "../../util/myprint.h"
#include <set>

using namespace std;


multiset<int, greater<int>> maxHeap;    // 降序排列，大根堆

/**
 * 最大堆; multiset.begin() 为最大值
 */
vector<int> getLeastNumbers1(vector<int>& arr, int k) {
    vector<int> res;
    if (arr.size() == 0 || k < 0 || k > arr.size())  {
        return res;
    }

    int size = arr.size();
    for (int i=0; i<size; ++i) {
        if (maxHeap.size() < k) {
            maxHeap.insert(arr[i]);  // insert
        } else {
            auto top = maxHeap.begin();
            if (*top > arr[i]) {
                maxHeap.erase(top); // erase
                maxHeap.insert(arr[i]);
            }
        }
    }

    for (const auto &e : maxHeap) {
        res.push_back(e);      // 结果也是倒序的
    }

    return res;
}

// 快排法
vector<int> getLeastNumbers(vector<int>& arr, int k) {
   vector<int> res;
   if (arr.size() == 0 || k < 0 || k > arr.size())  {
        return res;
   }

   int lo = 0;
   int hi = arr.size() - 1;
   int j = partition(arr, lo, hi);

   while (1) {
    if (j == k - 1) {  // &&& k-1
        break;
    } else if (j < k - 1) {
        lo = j + 1;
        j = partition(arr, lo, hi);
    } else {
        hi = j - 1;
        j = partition(arr, lo, hi);
    }
   }

   for (int i=0; i<k; ++i) {
     res.push_back(arr[i]);
   }

   return res;
}


int main(int argc, char **argv) {
    vector<int> arr{18, 24, 3, 8, 5, 4, 9, 10};

    //auto res = getLeastNumbers(arr, 3);
    auto res = getLeastNumbers1(arr, 3);
    show(res);

    return 0;
}

