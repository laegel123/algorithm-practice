/**
 * @author laege
 * @version 1.0
 * @since 2026-01-11
 */

public class leetcode21 {
   static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode dummyNode = node;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummyNode.next = list2;
                list2 = list2.next;
            } else {
                dummyNode.next = list1;
                list1 = list1.next;
            }
            dummyNode = dummyNode.next;
        }

        if (list1 != null) {
            dummyNode.next = list1;
        } else {
            dummyNode.next = list2;
        }

        return node.next;
    }
}
