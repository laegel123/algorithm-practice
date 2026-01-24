
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def __init__(self):
        self.map = {}

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        if head in self.map:
            return self.map[head]

        copy = Node(head.val)
        self.map[head] = copy
        copy.next = self.copyRandomList(head.next)
        copy.random = self.map.get(head.random)
        return copy

    def copyRandomList2(self, head: 'Optional[Node]') -> 'Optional[Node]':
        map = {None: None}
        cur = head
        while cur:
            copy = Node(cur.val)
            map[cur] = copy
            cur = cur.next
        cur = head

        while cur:
            copy = map.get(cur)
            copy.next = map.get(cur.next)
            copy.random = map.get(cur.random)
            cur = cur.next

        return map[head]
