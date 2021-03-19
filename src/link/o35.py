"""

"""
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random

def copyRandomList(self, head):
    def dfs(head):
        if head == None: return None

        if head in visited:  return visited[head]

        copy = Node(head.val)
        visited[head] = copy

        copy.next = dfs(head.next)
        copy.random = dfs(head.random)
        return copy

    visited = {}    # <old, copy>
    return dfs(head)

###
if __main__ == '__main__':
    pass
