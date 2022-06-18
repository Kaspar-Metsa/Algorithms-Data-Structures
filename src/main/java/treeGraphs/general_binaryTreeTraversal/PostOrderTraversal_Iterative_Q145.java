package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class PostOrderTraversal_Iterative_Q145 {
    /*
        The purpose of first if is to push all nodes to the stack and then go as far left as we can (if we can go left)

        We never push right children to stack in the same outer loop iteration, when we go right, we do it new outer loop iteration while going left in the first IF block

        "if (cur == null)" means we have reached a point MAX LEFT where there are no more children to the left NOR to the right

        "Last" is the peek just before popping

        The first time we enter inner loop, the while loop is guaranteed to execute because
            1) Stack can't be empty because otherwise we would have broken out before.
            2) last is null because we just set it
            3) st.peek.right is null, because if it wasn't the "cur = st.peek.right + IF CUR==NULL" 2 lines above would not have been true

        The second time we enter inner loop:
            1) If stack is empty we are done because next outer loop iteration we break out because cur is guaranteed to be null, because if cur is not null, we would not have reached the previous inner loop
            2) We must have come from right child because after popping in inner loop, the while's peek.right is the last peek ONLY if we have ALREADY visited current peek's left child and previous pop MUST have been current peek's right child.

        We won't enter the inner loop if:
            1) We came from left child and we haven't yet explored the right child
            2) stack is empty

        We WILL enter the inner loop if(either first or subsequent entries):
            1) both left and right children are null
            2) we have already explored left child and right child is null
            3) we have already explored right child and left child is null
            4) we have already explored BOTH right child and left child - in this case we would have arrived here from right child

        Complexity
            Time:   O(n) the amount of work done for each node is constant: meaning,
                    we might pass a node multiple times: first when pushing to stack,
                    second when popping from stack and adding to answer - the final work will be constant.

                    The inner loop will execute n times because we print each node only once.
            Space:
                    O(h), so O(n) if skewed tree, O(logn) if balanced tree

    */
    List<Integer> postOrderTraversal_OneStack(TreeNode root) {
        var ans = new ArrayList<Integer>();
        var st = new ArrayDeque<TreeNode>();
        var cur = root;
        while (true) { //We do every line here O(n) times
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                if (st.isEmpty()) break;
                cur = st.peek().right;
                if (cur == null) {
                    TreeNode last = null;
                    while (!st.isEmpty() && st.peek().right == last) { // This is the hardest part: if stack is empty, game over. right child of top of the stack needs to be the same as the node we just popped.
                        last = st.pop();
                        ans.add(last.val);
                    }
                }
            }
        }
        return ans;
    }
}


//        Another way for 1 stack, more complicated - while condition is harder, temp variable is unnecessary, adding stack.peek().right to answer is less intuitive than adding stack.peek() to answer

//    public List<Integer> postOrderTraversal(TreeNode root) {
//        var ans = new ArrayList<Integer>();
//        if (root == null) return ans;
//        var stack = new ArrayDeque<TreeNode>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left; //visit left first
//            } else {
//                TreeNode temp = stack.peek().right; // left is done, we check whether we have right side unvisited
//                if (temp == null) { //right side is done, so we pop and add to answer
//                    temp = stack.pop();
//                    ans.add(temp.val);
//                    while (!stack.isEmpty() && stack.peek().right == temp) {
//                        temp = stack.pop();
//                        ans.add(temp.val); // right side is done
//                    }
//                } else {
//                    cur = temp; //deal with right side
//                }
//            }
//        }
//        return ans;
//    }

    /*
    The final result is correct by reversing the reverse-preorder.
    But the traversal order for postorder is not correct.
    This is important if we need to calculate children before the root.

    Consider a task/problem in which before calculating the value for the root, we need the value of the left and the right child to be already calculated.
    In this example, the value of the root depends on the values of its children.
    If we reverse the preorder traversal, when we start calculating the root, the children will not have been calculated yet.

    If there are no dependencies, all node values are already known and we simply need to add the root to result, then reverse reverse-preorder is correct.

    If the order in which nodes are visited is important then this solution will not be suitable.
    */
//    public List<Integer> postorderTraversalByFlippingReversedPreorder(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        LinkedList<Integer> ans = new LinkedList<>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            while (cur != null) {
//                ans.addFirst(cur.val);
//                stack.push(cur);
//                cur = cur.right;
//            }
//            cur = stack.pop();
//            cur = cur.left;
//        }
//        return ans;
//    }


    /*
            2 stack version, we reverse the reverse-preorder to get the final result

            Idea: Result stack will have postOrder traversal order when popping

            It traverses postOrder in reverse way
        */
//    List<Integer> postOrderTraversal_TwoStacks(TreeNode root) {
//        var ans = new ArrayList<Integer>();
//        if (root == null) return ans;
//
//        var st = new ArrayDeque<TreeNode>();
//        var result = new ArrayDeque<TreeNode>();
//
//        st.push(root);
//
//        while (!st.isEmpty()) {
//            TreeNode cur = st.peek();
//            st.pop();
//            result.push(cur);
//            if (cur.left != null) {
//                st.push(cur.left);
//            }
//            if (cur.right != null) {
//                st.push(cur.right);
//            }
//        }
//
//        while (!result.isEmpty()) {
//            ans.add(result.peek().val);
//            result.pop();
//        }
//
//        return ans;
//    }