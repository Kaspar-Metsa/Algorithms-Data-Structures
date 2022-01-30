package treeGraphs.bfs.Q111_minDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
