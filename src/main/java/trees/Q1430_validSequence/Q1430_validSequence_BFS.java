package trees.Q1430_validSequence;

import java.util.LinkedList;
import java.util.Queue;

import trees.util.TreeNode;

public class Q1430_validSequence_BFS {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty() && depth < arr.length) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                if (cur.val != arr[depth]) continue;
                if (depth == arr.length - 1 && (cur.left == null && cur.right == null)) return true;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);

                }
            }
            depth++;
        }
        return false;
    }
}
