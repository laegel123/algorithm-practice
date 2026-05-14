import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class leetcode133 {
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
