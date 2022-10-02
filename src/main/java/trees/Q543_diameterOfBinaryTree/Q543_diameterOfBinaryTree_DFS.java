package trees.Q543_diameterOfBinaryTree;

import trees.util.TreeNode;

/*
    https://docs.google.com/document/d/1MpLvCR2UvGzPtZSgjUZeD5S7mrLuVo_Ot4jWhucl3-s/edit

    Time O(N) because we visit each node once
    Space O(H) O(n) if skewed tree
*/

/*
    Bottom up without global variable
*/


public class Q543_diameterOfBinaryTree_DFS {
    public int diameterOfBinaryTree(TreeNode root) {
        final int[] max = {0}; // Same as int[] max = new int[]{0}; Better than global variable
        rec(root, max);
        return max[0];
    }

    private int rec(TreeNode node, final int[] max) {
        if (node == null) return 0;
        int left = rec(node.left, max);
        int right = rec(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
}




/*
    VARIATION
    Global variable, bad solution because global variables are bad practice
*/

//public class Q543_diameterOfBinaryTree {
//        private int diameter;
//        public int diameterOfBinaryTree(TreeNode root) {
//            diameter = 0;
//            longestPath(root);
//            return diameter;
//        }
//        private int longestPath(TreeNode node){
//            if(node == null) return 0;
//            int leftPath = longestPath(node.left);
//            int rightPath = longestPath(node.right);
//
//            diameter = Math.max(diameter, leftPath + rightPath);
//
//            // We add 1 for the path connecting the node and its parent
//            return Math.max(leftPath, rightPath) + 1;
//        }
//}
