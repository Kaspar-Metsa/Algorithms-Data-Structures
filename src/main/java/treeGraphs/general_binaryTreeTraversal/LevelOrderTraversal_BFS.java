package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import treeGraphs.util.TreeNode;

public class LevelOrderTraversal_BFS {
    List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            answer.add(currentNode.val);
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        return answer;
    }

    /*
        Time:
            First loop will be O(n) because we push to stack n times.
            Second loop will be O(n) because stack has n elements
        Space
            Max number of nodes in stack is always n
    */

    List<Integer> reverseLevelOrderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        var q = new ArrayDeque<TreeNode>();
        var st = new ArrayDeque<TreeNode>();

        q.offer(root);
        while (!q.isEmpty()) {
            var cur = q.peek();
            q.poll();
            st.push(cur);
            if (cur.right != null) {
                q.offer(cur.right);
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop().val);
        }
        return ans;
    }
}
