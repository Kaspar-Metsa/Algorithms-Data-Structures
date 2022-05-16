package treeGraphs.binary_search_tree.Q98_validate_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class Q98_validate_binary_search_tree_DFS_inorder {
    public boolean isValidBST(TreeNode root) {
        List<Integer> nodeValList = new ArrayList<>();
        inorder(root, nodeValList);
        return isSorted(nodeValList);
    }

    private void inorder(TreeNode node, List<Integer> nodeValList) {
        if (node != null) {
            inorder(node.left, nodeValList);
            nodeValList.add(node.val);
            inorder(node.right, nodeValList);
        }
    }

    private boolean isSorted(List<Integer> nodeValList) {
        for (int i = 1; i < nodeValList.size(); i++) {
            if (nodeValList.get(i) <= nodeValList.get(i - 1)) return false;
        }
        return true;
    }
}
