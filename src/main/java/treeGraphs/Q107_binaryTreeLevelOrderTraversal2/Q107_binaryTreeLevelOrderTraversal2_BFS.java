package treeGraphs.Q107_binaryTreeLevelOrderTraversal2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class Q107_binaryTreeLevelOrderTraversal2_BFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        var answer = new LinkedList<List<Integer>>();
        if (root == null) return answer;
        var queue = new ArrayDeque<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            var subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode currentNode = queue.remove();
                subList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            answer.addFirst(subList);
        }
        return answer;
    }
}
