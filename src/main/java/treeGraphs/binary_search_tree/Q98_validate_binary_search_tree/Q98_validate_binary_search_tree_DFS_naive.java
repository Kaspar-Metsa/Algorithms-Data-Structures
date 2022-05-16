package treeGraphs.binary_search_tree.Q98_validate_binary_search_tree;

import treeGraphs.util.TreeNode;

public class Q98_validate_binary_search_tree_DFS_naive {

    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (valid(root.left, root.val, true) && valid(root.right, root.val, false)) {
                return isValidBST(root.left) && isValidBST(root.right);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean valid(TreeNode root, long nodeVal, boolean lessThan) {
        if (root != null) {
            if (lessThan) {
                if (root.val >= nodeVal) return false;
            } else {
                if (root.val <= nodeVal) return false;
            }
            return valid(root.left, nodeVal, lessThan) && valid(root.right, nodeVal, lessThan);
        }
        return true;
    }
}
