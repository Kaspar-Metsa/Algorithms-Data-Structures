package trees.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.util.TreeNode;

public class InOrderTraversal_Iterative_Q94 {

    /*
        Idea is only once line difference to preorder using same technique (list.add)
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
//                preOrderAns.add(cur.val); FOR PREORDER
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversal_Reversed(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
//                preOrderAns.add(cur.val); FOR PREORDER
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.left;
        }
        return ans;
    }


    //    public List<Integer> inorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        List<Integer> ans = new ArrayList<>();
//        TreeNode current = root;
//
//        while (current != null || !stack.isEmpty()) {
//            if (current != null) {
//                stack.push(current);
//                current = current.left;
//            } else {
//                ans.add(stack.peek().val);
//                current = stack.pop().right;
//            }
//        }
//        return ans;
//    }
}
