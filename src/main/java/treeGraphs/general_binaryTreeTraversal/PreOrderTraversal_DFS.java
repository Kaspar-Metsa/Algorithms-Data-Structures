package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class PreOrderTraversal_DFS {

    List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        traversePreOrder(root, answer);
        return answer;
    }

    private void traversePreOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        answer.add(node.val);
        traversePreOrder(node.left, answer);
        traversePreOrder(node.right, answer);
    }
}
