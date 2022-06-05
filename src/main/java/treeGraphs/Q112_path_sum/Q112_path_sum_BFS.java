package treeGraphs.Q112_path_sum;

import java.util.ArrayDeque;

import treeGraphs.util.TreeNode;

public class Q112_path_sum_BFS {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        var visitedStack = new ArrayDeque<TreeNode>();
        var curSumStack = new ArrayDeque<Integer>();
        visitedStack.push(root);
        curSumStack.push(root.val);
        while (!visitedStack.isEmpty()) {
            TreeNode temp = visitedStack.pop();
            int tempVal = curSumStack.pop();
            if (temp.left == null && temp.right == null) {
                if (tempVal == sum) {
                    return true;
                }
            } else {
                if (temp.right != null) {
                    visitedStack.push(temp.right);
                    curSumStack.push(temp.right.val + tempVal);
                }
                if (temp.left != null) {
                    visitedStack.push(temp.left);
                    curSumStack.push(temp.left.val + tempVal);
                }

            }
        }
        return false;
    }
}
