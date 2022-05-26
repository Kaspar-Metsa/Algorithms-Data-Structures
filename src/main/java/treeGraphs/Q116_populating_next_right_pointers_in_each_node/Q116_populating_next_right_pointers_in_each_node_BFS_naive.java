package treeGraphs.Q116_populating_next_right_pointers_in_each_node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q116_populating_next_right_pointers_in_each_node_BFS_naive {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node rightNode = null;
            for (int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if (cur.right != null && cur.left != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }
}
