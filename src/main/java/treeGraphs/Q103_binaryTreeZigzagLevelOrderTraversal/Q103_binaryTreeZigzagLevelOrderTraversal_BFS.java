package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.*;

public class Q103_binaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) return listList;

        boolean normalOrder = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            normalOrder = !normalOrder;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (normalOrder) {
                    level.add(current.val);
                } else {
                    level.addFirst(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            listList.add(level);
        }
        return listList;
    }
}
