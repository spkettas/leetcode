/**
 * L239 滑动窗口最大值
 *
 *输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
  输出：[3,3,5,5,6,7]
  解释：
  滑动窗口的位置                最大值
  ---------------               -----
  [1  3  -1] -3  5  3  6  7       3
   1 [3  -1  -3] 5  3  6  7       3
   1  3 [-1  -3  5] 3  6  7       5
   1  3  -1 [-3  5  3] 6  7       5
   1  3  -1  -3 [5  3  6] 7       6
   1  3  -1  -3  5 [3  6  7]      7
 *
 * 1. 与 最小k 个数类似，如用最大堆处理，但是无法区别最先开始的值
 * 2. 优先队列
 * a. 最大堆
 * b. 超出窗口的要移除
 */

#include "../util/myprint.h"
#include <set>
#include <queue>


vector<int> maxSlidingWindow(vector<int>& nums, int k) {
    vector<int> res;
    if (nums.size() == 0 || k <= 0) {
        return res;
    }

    int n = nums.size();
    priority_queue<pair<int, int>> q;  // 大根堆

    // 预先k数
    for (int i=0; i<k; i++) {
        q.emplace(nums[i], i);  // &&&
    }

    res.push_back(q.top().first);

    for (int i=k; i<n; i++) {
        q.emplace(nums[i], i);  // &&&

        // 超出窗口的移除，比较巧妙. i-k定位到首节点 &&& <=
        while (q.top().second <= i - k) {
            q.pop();
        }

        res.push_back(q.top().first);
    }

    return res;
}

int main(int argc, char **argv) {
    vector<int> nums{1,3,-1,-3,5,3,6,7};
    auto res = maxSlidingWindow(nums, 3);
    show(res);

    return 0;
}


