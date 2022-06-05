package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import treeGraphs.util.TreeNode;

public class PostOrderTraversal_Iterative_Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; //visit left first
            } else {
                TreeNode temp = stack.peek().right; // left is done, we check whether we have right side unvisited
                if (temp == null) { //right side is null, so we pop and add to answer
                    temp = stack.pop();
                    ans.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        ans.add(temp.val); // right side is done
                    }
                } else {
                    cur = temp; //deal with right side
                }
            }
        }
        return ans;
    }

    /*
    Even though the final result is correct, imagine if there are topological dependencies among the nodes, the visiting order would be significant.
    Simply reversing the preorder result isn't right.

    Consider a task/problem in which to compute the root, you need the value of the left and the right child to be already computed -> this is where we use preorder traversal.
    If we just reverse the preorder traversal, at the time of computation of root, the children will not have been computed, which makes this traversal invalid.

    The suggested approach for reversal of preorder traversal works only because in this question the computation/task at root is just adding the root value to the result
    (this does not depend on the left or the right child). But in an actual scenario which requires post-order traversal, the task would require values of root.left and
    root.right to be computed. Hence it won't work.

    This solution visits nodes in reverse preorder (root, right, left) and then reverses this by inserting elements to the head of the output list instead of the tail.
    This produces the correct postorder output.
    However, if the order in which nodes are visited is important then this solution will not be suitable.
    Because of the reversal, this solution requires every node to be visited before the first element of the output can be used.
*/
//    public List<Integer> postorderTraversal(TreeNode root) {
//        LinkedList<Integer> ans = new LinkedList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        if (root == null) return ans;
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            ans.addFirst(cur.val);
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//        }
//        return ans;
//    }
}
