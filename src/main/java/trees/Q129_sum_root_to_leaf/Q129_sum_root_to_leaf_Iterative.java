package trees.Q129_sum_root_to_leaf;

import java.util.ArrayDeque;
import java.util.Deque;

import trees.util.TreeNode;

public class Q129_sum_root_to_leaf_Iterative {

    /*
        TODO: Morris
    */

/*
https://docs.google.com/document/d/13_WdENghzDHAgatuieFvNJNsBNz0aF8MV4sMJ8E9cP4/edit#
    Test cases
        1) 1 node value 0 -> return 0
        2) LinkedList 0-1, because one child null -> return 1

    Iterative preorder idea:
        Since we have to visit all nodes, the best possible time complexity here is linear.
        Hence, all interest here is to improve the space complexity.

        We traverse preorder because we need to concatenate all nodes in the path in root-to-leaf order. Inorder and postorder do not allow us to do that.

        There are 3 ways to implement preorder traversal: iterative, recursive and Morris.
        Iterative and recursive need O(h) size stack.
        Morris is constant space.

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
        Deque<TreeNode> visitedStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        visitedStack.push(root);
        sumStack.push(0);
        while (!visitedStack.isEmpty()) {
            TreeNode curNode = visitedStack.pop();
            int curSum = sumStack.pop();
            curSum = curSum * 10 + curNode.val;
            if (curNode.left == null && curNode.right == null) {
                answer += curSum;
            } else {
                if (curNode.right != null) {
                    visitedStack.push(curNode.right);
                    sumStack.push(curSum);
                }
                if (curNode.left != null) {
                    visitedStack.push(curNode.left);
                    sumStack.push(curSum);
                }
            }
        }
        return answer;
    }

//    With Pair
//    int sumNumbers(TreeNode root) {
//        int answer = 0;
//        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
//        stack.push(new Pair<>(root, 0));
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> curPair = stack.pop();
//            TreeNode curNode = curPair.getKey();
//            int curSum = curPair.getValue();
//            curSum = curSum * 10 + curNode.val;
//            if (curNode.left == null && curNode.right == null) {
//                answer += curSum;
//            } else {
//                if (curNode.right != null) {
//                    stack.push(new Pair<>(curNode.right, curSum));
//                }
//                if (curNode.left != null) {
//                    stack.push(new Pair<>(curNode.left, curSum));
//                }
//            }
//        }
//        return answer;
//    }
}
