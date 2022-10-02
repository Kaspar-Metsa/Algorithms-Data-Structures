package trees.Q104_maxDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import trees.util.TreeNode;

public class Q104_maxDepthOfBinaryTree_BFS {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        int maxSoFar = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode currentNode = queue.remove();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            maxSoFar++;
        }
        return maxSoFar;
    }
}
