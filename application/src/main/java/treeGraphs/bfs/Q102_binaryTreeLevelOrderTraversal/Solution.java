package treeGraphs.bfs.Q102_binaryTreeLevelOrderTraversal;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.remove();
                currentLevelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            answer.add(currentLevelList);
        }
        return answer;
    }
}
