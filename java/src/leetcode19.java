import java.util.ArrayList;
import java.util.List;

/**
 * @author laege
 * @version 1.0
 * @since 2026-01-20
 */

class Leetcode19 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int idx = list.size() - n;

        if (idx == 0) {
            return head.next;
        }

        list.get(idx - 1).next = list.get(idx).next;

        return head;
    }
}
