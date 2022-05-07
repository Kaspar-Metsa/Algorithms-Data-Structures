package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103_binaryTreeZigzagLevelOrderTraversal_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(root, ans, 0);
        return ans;
    }

    private void traverse(TreeNode cur, List<List<Integer>> ans, int lvl) {
        if (cur == null) return;
        if (ans.size() == lvl) ans.add(new LinkedList<>()); // This can't be ArrayList, because we use addFirst() later, because adding to start of ArrayList is O(n)
        LinkedList<Integer> currentLevelList = (LinkedList<Integer>) ans.get(lvl); // This casting is necessary because signature from exercise requires returning List<List<Integer>>. In a perfect world we would use ArrayDeque

        if (lvl % 2 == 0) {
            currentLevelList.addLast(cur.val); // equivalent to add
        } else {
            currentLevelList.addFirst(cur.val); //Because lvlColl.add(0, cur.val); will move every element forward by 1 index. We cast because addFirst() is a Deque interface method, not List interface method
        }

        traverse(cur.left, ans, lvl + 1);
        traverse(cur.right, ans, lvl + 1);
    }
}
