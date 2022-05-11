package treeGraphs.Q199_rightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import treeGraphs.util.TreeNode;

public class Q199_rightSideView_BFS {


    public List<Integer> rightSideView_ReverseLevelOrderWithPeek(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            answer.add(queue.peek().val);
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) { //for leftside view we start with left
                    queue.offer(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
            }
        }
        return answer;
    }

    public List<Integer> rightSideView_ReverseLevelOrder(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0) {
                    answer.add(currentNode.val);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
            }
        }
        return answer;
    }

    public List<Integer> rightSideView_LevelOrder(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == queueSize - 1) {
                    answer.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return answer;
    }
}
