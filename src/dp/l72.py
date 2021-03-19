"""
 * 编辑距离
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 1.dp  指针从后向前遍历
 * dp(i,j) = min(dp(i, j-1) + 1,    # insert
                 dp(i-1, j) + 1,    # delete
                 dp(i-1, j-1) + 1)    # replace
"""

def minDistance(s1, s2):
    memo = dict()

    def dp(i, j):
        if (i, j) in memo:
            return memo[(i, j)]

        if i == -1: return j+1
        if j == -1: return i+1

        if s1[i] == s2[j]:
            memo[(i, j)] = dp(i-1, j-1)  # skip
        else:
            memo[(i, j)] = min(
                dp(i, j-1) + 1,     # insert
                dp(i-1, j) + 1,     # delete
                dp(i-1, j-1) + 1    # replace
            )
        return memo[(i, j)]

    return dp(len(s1) -1, len(s2) -1)

if __name__ == '__main__':
    size = minDistance("horse", "ros")
    print("distance: ", size)
    pass
