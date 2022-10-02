package trees.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import trees.util.TreeNode;

public class PostOrderTraversal_Recursive {

    List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        traversePostOrder(root, answer);
        return answer;
    }

    private void traversePostOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        traversePostOrder(node.left, answer);
        traversePostOrder(node.right, answer);
        answer.add(node.val);
    }

    List<Integer> postOrderTraversalReversed(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        reverseTraversePostOrder(root, answer);
        return answer;
    }

    private void reverseTraversePostOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        reverseTraversePostOrder(node.right, answer);
        reverseTraversePostOrder(node.left, answer);
        answer.add(node.val);
    }
}
