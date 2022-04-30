package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.*;

public class Q103_binaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean rtl = false;
        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int qSize = q.size();
            rtl = !rtl;
            for (int i = 0; i < qSize; i++) {
                TreeNode cNode = q.remove();
                if (rtl) {
                    level.addLast(cNode.val);
                } else {
                    level.addFirst(cNode.val);
                }
                if (cNode.left != null) {
                    q.offer(cNode.left);
                }
                if (cNode.right != null) {
                    q.offer(cNode.right);
                }
            }
            answer.add(level);
        }
        return answer;
    }


//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> listList = new ArrayList<>();
//        if (root == null) return listList;
//
//        boolean ltr = false;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            LinkedList<Integer> level = new LinkedList<>();
//            ltr = !ltr;
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = q.poll();
//                if (ltr) {
//                    level.addLast(cur.val);
//                } else {
//                    level.addFirst(cur.val);
//                }
//                if (cur.left != null) {
//                    q.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    q.offer(cur.right);
//                }
//            }
//            listList.add(level);
//        }
//        return listList;
//    }
}
