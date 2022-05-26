package treeGraphs.Q116_populating_next_right_pointers_in_each_node;

public class Q116_populating_next_right_pointers_in_each_node_DFS {
    public Node connect(Node node) {
        if (node == null) return null;
        Node left = node.left;
        if (left != null) {
            Node right = node.right;
            Node next = node.next;
            left.next = right;
            if (next != null) right.next = next.left;
            connect(left);
            connect(right);
        }
        return node;
    }
}
