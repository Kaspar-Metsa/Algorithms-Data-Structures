package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103_binaryTreeZigzagLevelOrderTraversal_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>(); //This could also be LinkedList
        traverse(root, sol, 0);
        return sol;
    }

    private void traverse(TreeNode cur, List<List<Integer>> sol, int lvl) {
        if (cur == null) return;

        if (sol.size() <= lvl) {
            LinkedList<Integer> newLvl = new LinkedList<>();//This can't be ArrayList, because we use addFirst() later
            sol.add(newLvl);
        }

        List<Integer> lvlList = sol.get(lvl);
        if (lvl % 2 == 0) {
            lvlList.add(cur.val); // Same as addLast in LinkedList
        } else {
            ((LinkedList<Integer>) lvlList).addFirst(cur.val); //Because lvlColl.add(0, cur.val); will move every element forward by 1 index. We cast because addFirst() is a Deque interface method, not List interface method
        }

        traverse(cur.left, sol, lvl + 1);
        traverse(cur.right, sol, lvl + 1);
    }
}
