/**
 * 第k个最大数，与最小k个数解法一致
 *
 * 1.快排
 */
#include "../../util/myprint.h"


int findKthLargest(vector<int> &nums, int k) {
    if (nums.size() == 0 || k < 0 || k > nums.size()) {
        return -1;
    }

    int target = nums.size() - k;   // &&&
    int lo = 0;
    int hi = nums.size() - 1;
    int j = partition(nums, lo, hi);

    while (1) {
        if (j == target) {
            return nums[j];
        } else if (j > target) {
            hi = j - 1;
            j = partition(nums, lo, hi);
        } else {
            lo = j + 1;
            j = partition(nums, lo, hi);
        }
    }

    return -1;
}


int main(int argc, char **argv) {
    //vector<int> arr{18, 24, 3, 8, 5, 4, 9, 10};
    vector<int> arr{1,3,5,2,2};

    auto res = findKthLargest(arr, 3);
    printf("res: %d\n", res);
    return 0;
}