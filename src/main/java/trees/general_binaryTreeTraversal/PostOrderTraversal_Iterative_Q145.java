package trees.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.util.TreeNode;

public class PostOrderTraversal_Iterative_Q145 {


/*
            1
        /       \
       2         3
     /  \      /   \
    4   5     6     7

// Postorder
// 4, 5, 2, 6, 7, 3, 1
// Postorder reversed
// 1, 3, 7, 6, 2, 5, 4
 */

    /*
        2 stack version, we reverse the reverse-preorder to get the final result
        Space O(n) because the worst case is when every node is in one of the two stacks.
        Node can never be at both of the stacks at the same time.
    */

    //    public List<Integer> postOrderIterative2Stacks(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) return ans;
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        Deque<TreeNode> result = new ArrayDeque<>();
//        stack.push(root);
//        //Time O(n)
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.push(node);
//            if (node.left != null) stack.push(node.left);
//            if (node.right != null) stack.push(node.right);
//        }
//        //Time O(n)
//        while (!result.isEmpty()) {
//            ans.add(result.pop().val);
//        }
//        return ans;
//    }
/*
    The purpose of first loop if is to push all nodes to the stack and then go as far left as we can

    We never push right children to stack in the same outer loop iteration, when we go right, we do it new outer loop iteration while going left in the first IF block

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












    /*
        cur==null when
            1) We went left until hit null
            2) We went right until hit null, popped until ???, cur remained null
    */
    /*
       "!st.isEmpty()" - True after the root is popped from stack
       "st.peek().right == last" - True from inside loop when
                                      1) After popping right child
                                 - False from inside loop when
                                      1) After popping left child
                                 - True from outside loop when
                                      1) We have gone max left and right child is null
                                 - False from outside loop when
                                     1) we haven't yet visited st.peek.right - makes sense because postorder works like that: left, right, node
                                     2)(same) we popped left and when coming back, st.peek.right is not null


   */
    //FAQ
    // Always when I change direction from left to right, I change cur from null to a value but never enter the second while loop?
    //      Because I want to first explore left children, because that is how postorder works: left, right, node
    // When do I push right children?
    //  When cur!=null
//    List<Integer> postOrderTraversal_OneStack(TreeNode root) {
//        var ans = new ArrayList<Integer>();
//        var st = new ArrayDeque<TreeNode>();
//        var cur = root;
//        while (true) { // We do every line here O(n) times
//            if (cur != null) {
//                st.push(cur);
//                cur = cur.left;
//            } else {
//                if (st.isEmpty()) break; // Only at the very end.
//                cur = st.peek().right; // Every time we go right
//                TreeNode last = null;
//                if(st.peek().right != last){
//                    System.out.println("test");
//                }
//                while (!st.isEmpty() && st.peek().right == last) {
//                    last = st.pop();
//                    ans.add(last.val);
//                }
//            }
//        }
//        return ans;
//    }


    /*
         "if (peek.right != null && peek.right != last)"
            1)(peek.right != null && peek.right != last)
                a)We haven't explored right child yet
            2) else
                a)peek.right != null && peek.right == last
                    1) When we just popped st.peek().right and coming back
                b)peek.right == null && peek.right != last:
                    1) from 2nd leaf
                    2) When we just popped st.peek().left, coming back and st.peek().right==null
                c)peek.right == null && peek.right == last
                    1)First leaf is reached
     */
    public List<Integer> postOrderTraversal_OneStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode last = null;

        while (!st.isEmpty() || cur != null) { // At START (st.isEmpty() and cur!=null), at END (st.isEmpty() and cur==null)
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = st.peek();
                if (peek.right != null && peek.right != last) {
                    cur = peek.right;
                } else {
                    last = st.pop();
                    ans.add(last.val);
                }
            }
        }
        return ans;
    }



























/*
    Easier version of postorder
*/
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode lastNodeVisited = null;
//        TreeNode curr = root;
//        while(!stack.isEmpty() || curr != null) {
//            if(curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            } else {
//                TreeNode x = stack.peek();
//                if (x.right != null && x.right != lastNodeVisited) {
//                    curr = x.right;
//                } else {
//                    res.add(x.val);
//                    stack.pop();
//                    lastNodeVisited = x;
//                }
//            }
//        }
//        return res;
//    }

    /*
                1
            /       \
           2         3
         /  \      /   \
        4   5     6     7
      / \  / \   / \   /\
     8  9 10 11 12 13 14 15
    */
//    8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1

//    public List<Integer> diameterOfBinaryTree(TreeNode root) {
//        List<Integer> ansList = new ArrayList<>();
//        if (root == null) return ansList;
//        Deque<TreeNode> nodeStack = new ArrayDeque<>();
//        Map<TreeNode, Integer> nodePathCountMap = new HashMap<>();
//        nodeStack.push(root);
//        while (!nodeStack.isEmpty()) {
//            TreeNode node = nodeStack.peek();
//            if (node.left != null && !nodePathCountMap.containsKey(node.left)) {
//                nodeStack.push(node.left);
//            } else if (node.right != null && !nodePathCountMap.containsKey(node.right)) {
//                nodeStack.push(node.right);
//            } else {
//                TreeNode rootNodeEndOfPostOrder = nodeStack.pop();
//                ansList.add(rootNodeEndOfPostOrder.val);
//                nodePathCountMap.put(rootNodeEndOfPostOrder, 0);
//            }
//        }
//        return ansList;
//    }
    /*
        ansList=
        nodeStack=8,4,2,1
        nodePathCountMap=
        node=1
        rootNodeEndOfPostOrder=


    */


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
}
