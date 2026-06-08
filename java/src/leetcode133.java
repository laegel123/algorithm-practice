import java.util.HashMap;
import java.util.Map;


public class leetcode133 {
    class Node {
        public int val;
        public leetcode116.Node left;
        public leetcode116.Node right;
        public leetcode116.Node next;
        public Node neighbor;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, leetcode116.Node _left, leetcode116.Node _right, leetcode116.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return dfs(node);
    }

    public Node dfs(Node node) {
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n));
        }

        return clone;
    }
}
