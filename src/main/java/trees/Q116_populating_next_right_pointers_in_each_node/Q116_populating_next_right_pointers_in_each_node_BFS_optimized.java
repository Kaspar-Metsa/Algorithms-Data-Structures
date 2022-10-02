package trees.Q116_populating_next_right_pointers_in_each_node;

public class Q116_populating_next_right_pointers_in_each_node_BFS_optimized {
    public Node connect(Node root) {
        Node head = root;
        for (; root != null; root = root.left) {
            for (Node cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) cur.right.next = cur.next.left;
                } else break;
            }
        }
        return head;
    }
}
