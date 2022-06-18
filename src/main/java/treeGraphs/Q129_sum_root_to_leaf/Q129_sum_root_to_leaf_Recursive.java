package treeGraphs.Q129_sum_root_to_leaf;

import treeGraphs.util.TreeNode;

public class Q129_sum_root_to_leaf_Recursive {

    /*
        Time complexity: O(N) since we have to visit each node.
        Space complexity: up to O(H) to keep the recursion stack.
    */

    /*
        Recursive preorder without global variable CLEAN
    */

    int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    int traverse(TreeNode node, int curSum) {
        if (node == null) return 0;
        curSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return curSum;
        }
        return traverse(node.left, curSum) + traverse(node.right, curSum);
    }

    /*
        Recursive preorder without global variable NOT CLEAN
    */

//    int sumNumbers(TreeNode root) {
//        int[] answer = new int[]{0};
//        traverse(root, 0, answer);
//        return answer[0];
//    }
//
//    void traverse(TreeNode root, int currValue, int[] answer) {
//        if (root == null) return;
//        currValue = currValue * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            answer[0] += currValue;
//        } else {
//            traverse(root.left, currValue, answer);
//            traverse(root.right, currValue, answer);
//        }
//    }

    /*
        Recursive preorder with global variable
    */
//    int rootToLeaf = 0;
//    public void preorder(TreeNode r, int currNumber) {
//        if (r != null) {
//            currNumber = currNumber * 10 + r.val;
//            if (r.left == null && r.right == null) {
//                rootToLeaf += currNumber;
//            }
//            preorder(r.left, currNumber);
//            preorder(r.right, currNumber) ;
//        }
//    }
//
//    public int sumNumbers(TreeNode root) {
//        preorder(root, 0);
//        return rootToLeaf;
//    }

}
