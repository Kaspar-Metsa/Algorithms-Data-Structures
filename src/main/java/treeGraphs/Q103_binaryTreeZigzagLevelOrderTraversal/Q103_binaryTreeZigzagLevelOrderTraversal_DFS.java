package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103_binaryTreeZigzagLevelOrderTraversal_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new LinkedList<>();
        traverse(root, sol, 0);
        return sol;
    }

    private void traverse(TreeNode cur, List<List<Integer>> sol, int lvl) {
        if (cur == null) return;

        if (sol.size() <= lvl) {
            LinkedList<Integer> newLvl = new LinkedList<>();
            sol.add(newLvl);
        }

        LinkedList<Integer> lvlList = (LinkedList<Integer>) sol.get(lvl); // This casting is necessary because signature from exercise requires returning List<List<Integer>>. In a perfect world we would use ArrayDeque
        if (lvl % 2 == 0) {
            lvlList.addLast(cur.val); // equivalent to add
        } else {
            lvlList.addFirst(cur.val); //Because lvlColl.add(0, cur.val); will move every element forward by 1 index. We cast because addFirst() is a Deque interface method, not List interface method
        }

        traverse(cur.left, sol, lvl + 1);
        traverse(cur.right, sol, lvl + 1);
    }
}
