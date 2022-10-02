package trees.binary_search_tree.Q98_validate_binary_search_tree;

import trees.util.TreeNode;

public class Q98_validate_binary_search_tree_DFS_limits {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return isValid(node.right, node.val, high) && isValid(node.left, low, node.val);
    }
}
