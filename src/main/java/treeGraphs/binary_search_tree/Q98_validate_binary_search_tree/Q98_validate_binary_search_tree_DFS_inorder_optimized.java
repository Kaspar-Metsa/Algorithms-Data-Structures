package treeGraphs.binary_search_tree.Q98_validate_binary_search_tree;

import treeGraphs.util.TreeNode;

public class Q98_validate_binary_search_tree_DFS_inorder_optimized {

    /*
        We can't pass boolean or Integer to recursive function because Java is pass by value and Java makes a copy of the variable.
        We could make a MyInteger class, put prev inside that class and pass MyInteger - then we can change prev inside MyInteger.

        We can store isValid as instance variable and refer to it as this.isValid.
        We can store prev as instance variable and refer to it as this.prev.
        Not sure if better...
    */

    boolean isValid = true;
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return this.isValid;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (this.prev != null && this.prev >= node.val) {
                this.isValid = false;
                return;
            }
            this.prev = node.val;
            inorder(node.right);
        }
    }


//    public boolean isValidBST(TreeNode root) {
//        boolean[] isValid = new boolean[]{true};
//        Integer[] prev = new Integer[]{null};
//        inorder(root, prev, isValid);
//        return isValid[0];
//    }
//
//    private void inorder(TreeNode node, Integer[] prev, boolean[] isValid) {
//        if (node != null) {
//            inorder(node.left, prev, isValid);
//            if (prev[0] != null && prev[0] >= node.val) {
//                isValid[0] = false;
//                return;
//            }
//            prev[0]=node.val;
//            inorder(node.right, prev, isValid);
//        }
//    }
}