 /**
  * 一. fibonacci-斐波那契数列
  * 1. 递归法；自顶向下
  * 2. 带memo的递归
  * 3. 动态规划
  * 4. 迭代法（状态压缩）
  *
  * 二. 爬楼梯
  * 三. o10 大数的斐波那契数列
  */
#include <stdio.h>
#include <vector>

using namespace std;

// 1. 递归
int fib(int n) {
    if (n == 0)     return 0;
    if (n == 1 || n ==2) return 1;

    return fib(n - 1) + fib(n - 2);
}

int helper(vector<int> &memo, int n) {
    if (n == 1 || n ==2) return 1;  // &&&
    if (memo[n] != 0) return memo[n];

    // update
    memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
    return memo[n];
}

// 2. 带memo的递归
int fib1(int n) {
    if (n == 0) return 0;

    vector<int> memo(n + 1, 0);
    return helper(memo, n);
}

// 3. 动态规划 - 自底向上
int fib2(int n) {
    // base class
    if (n == 0)     return 0;
    if (n == 1 || n ==2) return 1;

    vector<int> dp(n + 1, 0);
    dp[1] = dp[2] = 1;

    for (int i=3; i<=n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
}

/**
 * 4. 迭代法
 * 5. 求mod的大数
 * pre = cur % MOD;  cur = sum % MOD;
 * f(n) = f(n-1) + f(n-2)
 */
int fib3(int n) {
   if (n == 0)     return 0;
   if (n == 1 || n ==2) return 1;

   int prev = 1, cur = 1;

   // &&& 3
   for (int i=3; i<=n; i++) {
        int sum = prev + cur;
        prev = cur;
        cur = sum;
   }

   return cur;  // &&&
}

// 5. 爬楼梯
int climbStairs(int n) {
   // &&&
   if (n < 3)      return n;

   int prev = 1, cur = 1;

   // &&& i=2
   for (int i=2; i<=n; i++) {
        int sum = prev + cur;
        prev = cur;
        cur = sum;
   }

   return cur;
}

int main(int argc, char **argv)  {
    int val = fib(20);
    printf("fib: %d\n", val);

    val = fib1(20);
    printf("fib: %d\n", val);

    val = fib2(20);
    printf("fib: %d\n", val);

    val = fib3(45);
    printf("fib: %d\n", val);

    val = climbStairs(45);
    printf("climb: %d\n", val);


    return 0;
}