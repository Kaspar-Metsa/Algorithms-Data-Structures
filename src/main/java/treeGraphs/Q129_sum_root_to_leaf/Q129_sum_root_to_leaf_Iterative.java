package treeGraphs.Q129_sum_root_to_leaf;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;
import treeGraphs.util.TreeNode;

public class Q129_sum_root_to_leaf_Iterative {

    /*
        TODO: Morris
    */


/*
    Iterative preorder idea:
        Since we have to visit all nodes, the best possible time complexity here is linear.
        Hence, all interest here is to improve the space complexity.

        We choose preorder because we need to concatenate all nodes in the path in order. Inorder and postorder do not allow us to do that.

        There are 3 ways to implement preorder traversal: iterative, recursive and Morris.
        Iterative and recursive need O(h) size stack.
        Morris is constant space.
*/
    /*
        Iterative solution
        Time: O(n) because we traverse all nodes
        Space: O(h) is the stack. O(n) stack will be reached with a tree like this:
             1
           /  \
          2   3
         / \
        4  5
       / \
      6  7
     /\
    8  9

    */

    int sumNumbers(TreeNode root) {
        int answer = 0;
        int currValue;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode curNode = p.getKey();
            currValue = p.getValue();
            if (curNode != null) {
                currValue = currValue * 10 + curNode.val;
                if (curNode.left == null && curNode.right == null) {
                    answer += currValue;
                } else {
                    stack.push(new Pair<>(curNode.right, currValue));
                    stack.push(new Pair<>(curNode.left, currValue));
                }
            }
        }
        return answer;
    }
}
