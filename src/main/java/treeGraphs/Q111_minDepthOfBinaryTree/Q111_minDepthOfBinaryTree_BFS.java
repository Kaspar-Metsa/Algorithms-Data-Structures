package treeGraphs.Q111_minDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import treeGraphs.util.TreeNode;

public class Q111_minDepthOfBinaryTree_BFS {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        int depth = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
