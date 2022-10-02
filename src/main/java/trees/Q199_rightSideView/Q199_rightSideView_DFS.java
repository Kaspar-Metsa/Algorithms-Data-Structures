package trees.Q199_rightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.util.TreeNode;

public class Q199_rightSideView_DFS {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        rightView(root, answer, 0);
        return answer;
    }

    private void rightView(TreeNode curNode, List<Integer> answer, int depth) {
        if (curNode == null) {
            return;
        }
        if (depth == answer.size()) {
            answer.add(curNode.val);
        }

        rightView(curNode.right, answer, depth + 1);
        rightView(curNode.left, answer, depth + 1);
    }

    public List<Integer> rightSideView_WithStacks(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> levelStack = new ArrayDeque<>();

        if (root != null) {
            nodeStack.push(root);
            levelStack.push(0);
        }

        while (nodeStack.size() > 0) {
            TreeNode currentNode = nodeStack.pop();
            int level = levelStack.pop();
            if (answer.size() == level) answer.add(currentNode.val);
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                levelStack.push(level + 1);
            }
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                levelStack.push(level + 1);
            }
        }

        return answer;
    }
}
