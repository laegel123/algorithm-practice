from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        n1 = 0
        n2 = 0

        while l1:
            n1 = n1 * 10
            n1 += l1.val
            l1 = l1.next

        while l2:
            n2 = n2 * 10
            n2 += l2.val
            l2 = l2.next

        reverse_n1 = int(str(n1)[::-1])
        reverse_n2 = int(str(n2)[::-1])
        n3 = reverse_n1 + reverse_n2
        str_n3 = str(n3)[::-1]

        res = ListNode()
        cur = res
        for i in range(len(str_n3)):
            node = ListNode(int(str_n3[i]))
            cur.next = node
            cur = node

        return res.next








