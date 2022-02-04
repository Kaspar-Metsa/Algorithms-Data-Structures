package treeGraphs.Q104_maxDepthOfBinaryTree;

import treeGraphs.util.TreeNode;

import java.util.Stack;

public class Q104_maxDepthOfBinaryTree_DFSIterative {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();
        stack.push(root);
        values.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            Integer tempDepth = values.pop();
            max = Math.max(tempDepth, max);
            if (current.left != null) {
                stack.push(current.left);
                values.push(tempDepth + 1);
            }
            if (current.right != null) {
                stack.push(current.right);
                values.push(tempDepth + 1);
            }
        }
        return max;
    }
}
