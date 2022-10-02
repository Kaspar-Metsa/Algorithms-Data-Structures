package trees.Q104_maxDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

import trees.util.TreeNode;

public class Q104_maxDepthOfBinaryTree_DFSIterative {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(root);

        Deque<Integer> depthStack = new ArrayDeque<>();
        int maxDepth = 1;
        depthStack.push(maxDepth);

        while (!nodeStack.isEmpty() && !depthStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            int curMaxDepth = depthStack.pop();
            maxDepth = Math.max(maxDepth, curMaxDepth);
            if (curNode.left != null) {
                nodeStack.push(curNode.left);
                depthStack.push(curMaxDepth + 1);
            }
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
                depthStack.push(curMaxDepth + 1);
            }
        }
        return maxDepth;
    }
}
