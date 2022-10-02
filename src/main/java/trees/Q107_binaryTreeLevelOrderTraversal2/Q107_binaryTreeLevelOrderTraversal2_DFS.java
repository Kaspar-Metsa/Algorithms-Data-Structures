package trees.Q107_binaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.List;

import trees.util.TreeNode;

public class Q107_binaryTreeLevelOrderTraversal2_DFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        var result = new ArrayList<List<Integer>>();
        preOrder(root, 0, result);
        return result;
    }

    private void preOrder(TreeNode node, int level, ArrayList<List<Integer>> result) {
        if (node == null) return;
        if (level >= result.size()) result.add(0, new ArrayList<>());
        List<Integer> currentLevel = result.get(result.size() - level - 1);
        currentLevel.add(node.val);
        preOrder(node.left, level + 1, result);
        preOrder(node.right, level + 1, result);
    }
}
