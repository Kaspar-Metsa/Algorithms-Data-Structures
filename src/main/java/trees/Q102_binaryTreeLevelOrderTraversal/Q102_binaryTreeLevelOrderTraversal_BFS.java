package trees.Q102_binaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import trees.util.TreeNode;

public class Q102_binaryTreeLevelOrderTraversal_BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevelList = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.remove();
                currentLevelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            answer.add(currentLevelList);
        }
        return answer;
    }
}
