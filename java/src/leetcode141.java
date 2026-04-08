import java.util.HashSet;

/**
 * @author laegel
 * @version 1.0
 * @since 2026-01-19
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }

        return false;
    }
}
