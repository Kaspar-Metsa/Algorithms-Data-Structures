package treeGraphs.Q104_maxDepthOfBinaryTree;

import java.util.ArrayDeque;

import treeGraphs.util.TreeNode;

public class Q104_maxDepthOfBinaryTree_DFSIterative {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>();
        ArrayDeque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.push(root);
        depthStack.push(1);
        int maxDepthSoFar = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            int currentMaxDepth = depthStack.pop();
            maxDepthSoFar = Math.max(currentMaxDepth, maxDepthSoFar);
            if (current.left != null) {
                nodeStack.push(current.left);
                depthStack.push(currentMaxDepth + 1);
            }
            if (current.right != null) {
                nodeStack.push(current.right);
                depthStack.push(currentMaxDepth + 1);
            }
        }
        return maxDepthSoFar;
    }
}
