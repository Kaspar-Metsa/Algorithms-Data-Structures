package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class InOrderTraversal_DFS {

    List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        traverseInOrder(root, answer);
        return answer;
    }

    private void traverseInOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        traverseInOrder(node.left, answer);
        answer.add(node.val);
        traverseInOrder(node.right, answer);
    }
}
