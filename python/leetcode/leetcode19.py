from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        nodes = []
        cur = head

        while cur:
            nodes.append(cur)
            cur = cur.next

        remove_idx = len(nodes) - n
        if remove_idx == 0:
            return head.next

        nodes[remove_idx - 1].next = nodes[remove_idx].next

        return head

if __name__ == "__main__":
    s = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    print(s.removeNthFromEnd(head, 2))
