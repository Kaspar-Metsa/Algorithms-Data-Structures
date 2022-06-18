package treeGraphs.Q112_path_sum;

import java.util.ArrayDeque;

import treeGraphs.util.TreeNode;
/*
    Idea:
        Visited stack keeps record of visited nodes in a DFS way,
        curSumStack keeps record of sum until temp node(temp node value included).
        We only check if target sum equals to sum until current node when current node doesn't have any children, otherwise we keep adding to the sum.
        It doesn't matter if we check left or right subtrees first.

    Time: O(n) because worst case we visit all nodes
    Space: Worst case if tree looks like this, then space is O(n)
            1
           / \
          2   3
        /  \
       4   5
      / \
     6   7

*/

public class Q112_path_sum_BFS {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        var visitedStack = new ArrayDeque<TreeNode>();
        var curSumStack = new ArrayDeque<Integer>();
        visitedStack.push(root);
        curSumStack.push(root.val);
        while (!visitedStack.isEmpty()) {
            TreeNode temp = visitedStack.pop();
            int tempVal = curSumStack.pop();
            if (temp.left == null && temp.right == null && tempVal == sum) {
                return true;
            }
            if (temp.right != null) {
                visitedStack.push(temp.right);
                curSumStack.push(temp.right.val + tempVal);
            }
            if (temp.left != null) {
                visitedStack.push(temp.left);
                curSumStack.push(temp.left.val + tempVal);
            }
        }
        return false;

    }
}
