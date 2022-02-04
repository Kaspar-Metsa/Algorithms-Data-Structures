package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103_binaryTreeZigzagLevelOrderTraversal_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();
        traverse(root, solution, 0);
        return solution;
    }

    private void traverse(TreeNode current, List<List<Integer>> solution, int level) {
        if (current == null) return;

        if (solution.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            solution.add(newLevel);
        }

        List<Integer> collection = solution.get(level);
        if (level % 2 == 0) {
            collection.add(current.val);
        } else {
//            ((LinkedList<Integer>) collection).addFirst(current.val);
            collection.add(0, current.val);
        }

        traverse(current.left, solution, level + 1);
        traverse(current.right, solution, level + 1);
    }
}
