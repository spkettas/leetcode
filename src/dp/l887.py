"""
扔鸡蛋问题：用最少丢鸡蛋次数，确定楼层高度
你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。

1. dp 最小次数
线性搜索，状态：碎/没碎 选择：楼层
dp[i][j] = min(res, max(dp[i-1][j-1], dp[i][n-i]) + 1)

"""

def superEggDrop(k: int, n: int):
    memo = dict()  # &&&

    # k鸡蛋 n楼层
    def helper(K, N) -> int:
        if N == 0: return 0
        if K == 1: return N

        if (K, N) in memo:
            return memo[(K, N)]

        res = float('INF')
        for i in range(1, N+1):
            res = min(res, max(helper(K-1, i-1),
                               helper(K, N - i)) + 1)

        memo[(K, N)] = res
        return res

    return helper(k, n)

if __name__ == '__main__':
    cnt = superEggDrop(3, 14)
    print(cnt)
    pass