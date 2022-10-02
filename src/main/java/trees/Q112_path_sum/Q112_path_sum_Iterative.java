package trees.Q112_path_sum;

import java.util.ArrayDeque;
import java.util.Deque;

import trees.util.TreeNode;
/*
    https://docs.google.com/document/d/1e16-Ir3Va0QZ0YwcUZWpVE8NYm6Fcu4AIwKTfpXN9M0/edit#
    2 stack version

    Idea:
        Visited stack keeps record of visited nodes in a DFS way,
        curSumStack keeps record of sum until temp node(temp node value included).
        We only check if target sum equals to sum until current node when current node doesn't have any children, otherwise we keep adding to the sum.
        It doesn't matter if we check left or right subtrees first.
    Test cases:
        1) One answer
        2) No answer
    Edge cases:
        1) root is null -> false
        2) we reach sum before leaf -> false
        3) Multiple answers -> true

    Time: O(n) because worst case we visit all nodes
    Space: Worst case if tree looks like this, then space is O(n).

            1
           / \
          2   3
        /  \
       4   5
      / \
     6   7
     IMPORTANT#1: Worst case space complexity does not happen to completely left/right skewed tree(as linkedList), because we always add 2 children, pop 1.
     IMPORTANT#2: Worst case space complexity does not happen to this tree, because we add right before left, which means we always pop left before right, so nodes cant accumulate in stack:
          1
         / \
        5   2
           / \
          6   3
             / \
            7   4

*/

public class Q112_path_sum_Iterative {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Deque<TreeNode> visitedStack = new ArrayDeque<>();
        Deque<Integer> curSumStack = new ArrayDeque<>();
        visitedStack.push(root);
        curSumStack.push(root.val);
        while (!visitedStack.isEmpty()) {
            TreeNode temp = visitedStack.pop();
            int curSum = curSumStack.pop();
            if (temp.left == null && temp.right == null && curSum == sum) {
                return true;
            }
            if (temp.right != null) {
                visitedStack.push(temp.right);
                curSumStack.push(curSum + temp.right.val);
            }
            if (temp.left != null) {
                visitedStack.push(temp.left);
                curSumStack.push(curSum + temp.left.val);
            }
        }
        return false;
    }

    /*
        1 stack version
    */

//    public boolean hasPathSum(TreeNode root, int sum) {
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.add(new Pair<>(root, sum));
//        while(!stack.isEmpty()){
//            Pair<TreeNode, Integer> p = stack.poll();
//            TreeNode node = p.getKey();
//            int remain = p.getValue();
//            if(node != null){
//                remain -= node.val;
//                if(node.left == null && node.right == null && remain == 0) return true;
//                stack.add(new Pair<>(node.left, remain));
//                stack.add(new Pair<>(node.right, remain));
//            }
//        }
//        return false;
//    }
}