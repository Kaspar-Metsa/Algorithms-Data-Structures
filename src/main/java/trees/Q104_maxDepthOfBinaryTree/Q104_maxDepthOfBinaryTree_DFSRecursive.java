package trees.Q104_maxDepthOfBinaryTree;

import trees.util.TreeNode;

class Q104_maxDepthOfBinaryTree_DFSRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
/*
    Alternative DFS recursive, pretty unnecessary to pass in depth variable:
    public int maxDepth(TreeNode root) {
        return maxDep(root, 0);
    }
    public int maxDep(TreeNode ro, int dep){
        if(ro==null){
            return dep;
        }
        dep++;
        return Math.max(maxDep(ro.left, dep), maxDep(ro.right, dep));
    }
*/
}


