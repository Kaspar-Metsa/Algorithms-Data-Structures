package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class InOrderTraversalReversed_DFS {

    List<Integer> inOrderTraversalReversed(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        traverseInOrderReversed(root, answer);
        return answer;
    }

    private void traverseInOrderReversed(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        traverseInOrderReversed(node.right, answer);
        answer.add(node.val);
        traverseInOrderReversed(node.left, answer);
    }
}
