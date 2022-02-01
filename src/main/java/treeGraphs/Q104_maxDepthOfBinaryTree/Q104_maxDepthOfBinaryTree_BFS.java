package treeGraphs.Q104_maxDepthOfBinaryTree;

import treeGraphs.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q104_maxDepthOfBinaryTree_BFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSoFar = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                }
                if (node != null && node.right != null) {
                    queue.offer(node.right);
                }
            }
            maxSoFar++;
        }
        return maxSoFar;
    }
}
