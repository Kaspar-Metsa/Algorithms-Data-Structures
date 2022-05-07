package treeGraphs.Q111_minDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

import treeGraphs.util.TreeNode;

public class Q111_minDepthOfBinaryTree_BFS {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
