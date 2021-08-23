
/**
 * 1377. T 秒后青蛙的位置
 *
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 *
 * 1.dfs
 */

#include <vector>

using namespace std;


double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
    if (n == 1) return 1.0;

    vector<vector<int>> G(110);
    for (int i=0; i<n-1; i++) {
        int u = edges[i][0], v = edges[i][1];

        G[u].push_back(v);
        G[v].push_back(u);
    }

    return dfs(1, 0, t, target, G);
}

/**
 * @param u     进始点
 * @param fa    终止点
 * @param t  时间
 * @param G  图
 */
double dfs(int u, int fa, int t, int target, vector<vector<int>>& G) {
    int sz = G[u].size();

    if (!t || (fa && sz == 1)) {
        if (u == target) return 1;
        return 0;
    }

    double p = 1.0 / (fa ? sz - 1 : sz);
    double maxx = 0;

    // u边出发
    for (int i=0, sz = G[u].size(); i<sz; i++) {
        int v = G[u][i];
        if (v == fa) continue;

        maxx = max(maxx, dfs(v, u, t-1, target, G));
    }

    return p * maxx;
}


int main(int argc, char **argv)
{

    return 0;
}
