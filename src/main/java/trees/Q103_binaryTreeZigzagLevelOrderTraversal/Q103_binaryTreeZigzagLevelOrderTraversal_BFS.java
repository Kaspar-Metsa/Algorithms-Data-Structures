package trees.Q103_binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.util.TreeNode;

/*
    LinkedList addLast and addFirst are both O(1) because Java's LinkedList documentation says that:
    "All the operations perform as could be expected for a doubly-linked list"
    More specifically in linkLast() method, we can see that LinkedList holds a pointer to last element: "last=newNode"
*/
public class Q103_binaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int lvl = -1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            lvl++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cNode = queue.remove();
                if (lvl % 2 == 0) {
                    level.offer(cNode.val);
                } else {
                    level.offerFirst(cNode.val);
                }
                if (cNode.left != null) {
                    queue.offer(cNode.left);
                }
                if (cNode.right != null) {
                    queue.offer(cNode.right);
                }
            }
            answer.add(level);
        }
        return answer;
    }
}
