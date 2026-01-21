import java.util.ArrayList;
import java.util.List;

/**
 * @author laege
 * @version 1.0
 * @since 2026-01-20
 */
class Leetcode143 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curNode = head;

        while (curNode != null) {
            list.add(curNode);
            curNode = curNode.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i += 1;

            if (i >= j) {
                break;
            }

            list.get(j).next = list.get(i);
            j -= 1;
        }

        list.get(i).next = null;
    }
}
