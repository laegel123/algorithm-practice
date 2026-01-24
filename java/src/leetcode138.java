import java.util.HashMap;

/**
 * @author laegel
 * @version 1.0
 * @since 2026-01-23
 */

class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    private HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);

        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = map.get(head.random);
        return copy;
    }
}
