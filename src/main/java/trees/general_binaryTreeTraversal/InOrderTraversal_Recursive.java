package trees.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import trees.util.TreeNode;

public class InOrderTraversal_Recursive {

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
