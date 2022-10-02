package trees.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import trees.util.TreeNode;

public class PreOrderTraversal_Recursive {

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

    List<Integer> preOrderTraversalReversed(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        reverseTraversePreOrder(root, answer);
        return answer;
    }

    private void reverseTraversePreOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        answer.add(node.val);
        reverseTraversePreOrder(node.right, answer);
        reverseTraversePreOrder(node.left, answer);
    }
}
