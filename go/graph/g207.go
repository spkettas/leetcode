/**
 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。

返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/course-schedule-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

package graph

// findOrder [[1, 0]]	 0->1
// bfs
func FindOrder(numCourses int, prerequisites [][]int) []int {
	var (
		edges  = make([][]int, numCourses) // 邻接矩阵
		indeg  = make([]int, numCourses)   // 入度
		result []int
	)

	// 构造邻接矩阵
	for _, info := range prerequisites {
		edges[info[1]] = append(edges[info[1]], info[0]) // A <- B
		indeg[info[0]]++
	}

	q := []int{}
	for i := 0; i < numCourses; i++ {
		if indeg[i] == 0 {
			q = append(q, i)
		}
	}

	// 依次出栈，选择入度为0的节点
	for len(q) > 0 {
		u := q[0]
		q = q[1:] // pop
		result = append(result, u)

		for _, v := range edges[u] {
			indeg[v]--

			if indeg[v] == 0 {
				q = append(q, v)
			}
		}
	}

	if len(result) != numCourses {
		return []int{}
	}

	return result
}
