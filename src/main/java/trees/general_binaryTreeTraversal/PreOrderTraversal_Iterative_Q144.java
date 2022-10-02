package trees.general_binaryTreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.util.TreeNode;

/*
    PreOrder traversal also called Root-to-left traversal.
    We push right child before left child to stack because when we pop the stack the left child is returned first.

*/

public class PreOrderTraversal_Iterative_Q144 {

    /*
        This is superior way for iterative preorder traversal
    */

    List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ans.add(temp.val);
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversalReversed(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return ans;
    }

    /*
        Idea is only once line difference to inorder using same technique (list.add)
    */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        List<Integer> ans = new ArrayList<>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            while (cur != null) {
//                ans.add(cur.val);
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            // inOrderAns.add(cur.val); FOR INORDER
//            cur = cur.right;
//        }
//        return ans;
//    }
//
//    public List<Integer> preorderTraversalReversed(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        List<Integer> ans = new ArrayList<>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            while (cur != null) {
//                ans.add(cur.val);
//                stack.push(cur);
//                cur = cur.right;
//            }
//            cur = stack.pop();
//            // inOrderAns.add(cur.val); FOR INORDER
//            cur = cur.left;
//        }
//        return ans;
//    }


}
