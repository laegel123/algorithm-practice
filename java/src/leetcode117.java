import org.w3c.dom.Node;

public class leetcode117 {


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        dfs(root);

        return root;
    }

    public void dfs(Node root) {
        if (root == null) return;

        Node nextChild = findNextChild(root.next);

        if (root.right != null) {
            root.right.next = nextChild;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = nextChild;
            }
        }

        dfs(root.right);
        dfs(root.left);
    }

    public Node findNextChild(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }

            node = node.next;
        }

        return null;
    }
}
