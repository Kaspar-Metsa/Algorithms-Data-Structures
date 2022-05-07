package treeGraphs.general_binaryTreeTraversal;

import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class general_binaryTreeTraversal_BFS {

    List<Integer> generalTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            answer.add(currentNode.getVal());
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return answer;
    }
}
