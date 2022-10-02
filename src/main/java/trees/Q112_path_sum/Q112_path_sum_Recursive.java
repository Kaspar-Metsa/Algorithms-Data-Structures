package trees.Q112_path_sum;

import trees.util.TreeNode;

/*
    https://docs.google.com/document/d/1e16-Ir3Va0QZ0YwcUZWpVE8NYm6Fcu4AIwKTfpXN9M0/edit#
    Time: O(n) worst case we visit all nodes
    Space: O(h) for call stack. O(n) if skewed tree, O(logn) if balanced tree
*/

public class Q112_path_sum_Recursive {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == root.val) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}


//Alternative and longer way:
//
//
//    boolean hasPathSum(TreeNode root, int targetSum) {
//        return traverse(root, 0, targetSum);
//    }
//    boolean traverse(TreeNode node, int sum, int targetSum) {
//        if(node==null) return false;
//        int curSum = sum+node.val;
//        if (node.left==null && node.right == null && curSum == targetSum) {
//            return true;
//        }
//        return traverse(node.left, curSum, targetSum) || traverse(node.right, curSum, targetSum);
//    }