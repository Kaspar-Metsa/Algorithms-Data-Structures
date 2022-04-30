package treeGraphs.Q102_binaryTreeLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.*;

public class Q102_binaryTreeLevelOrderTraversal_BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevelList = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.remove();
                currentLevelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            answer.add(currentLevelList);
        }
        return answer;
    }
}
