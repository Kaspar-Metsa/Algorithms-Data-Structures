package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.*;

public class Q103_binaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if(root==null) return listList;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean ltf=false;
        while(!q.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size=q.size();
            ltf=!ltf;
            for(int i = 0; i<size;i++){
                TreeNode current = q.poll();
                if(ltf){
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);
                }
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            listList.add(level);
        }
        return listList;
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
