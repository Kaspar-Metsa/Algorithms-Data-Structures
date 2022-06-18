package treeGraphs.Q112_path_sum;

import treeGraphs.util.TreeNode;

/*
    Time: O(n) worst case we visit all nodes
    Space: O(h). O(n) if left skewed tree, O(logn) if balanced tree
*/

public class Q112_path_sum_DFS {
    public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null && node.val == sum) return true;
        return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
    }
}
