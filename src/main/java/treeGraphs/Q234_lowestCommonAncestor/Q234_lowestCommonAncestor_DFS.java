package treeGraphs.Q234_lowestCommonAncestor;

import treeGraphs.util.TreeNode;

public class Q234_lowestCommonAncestor_DFS {
    private TreeNode LCA;
    /*
        Early termination version of above
    */

    /*
        Idea: if a leaf is not equal to p or to q, we return null and keep propagating null to upper levels of the tree.
        If we manage to find a node equal to p or q we keep propagating that node to upper levels too, until at some node,
        its left and right nodes are both not null.
    */
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (node == p || node == q) return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left != null && right != null) return node;
        return (left == null) ? right : left;
    }

    public TreeNode lowestCommonAncestor3(TreeNode node, TreeNode p, TreeNode q) {
        // Terminate early if LCA was already found in another branch
        if (node == null || LCA != null) return null;
        if (node == p || node == q) return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left != null && right != null) {
            LCA = node;
            return LCA;
        }
        return (left == null) ? right : left;
    }

    /*
        Instead of TreeNode array we could also store answer in instance variable
    */

    private boolean traverse(TreeNode node, TreeNode p, TreeNode q, TreeNode[] ans) {
        if (node == null) return false;
        int left = traverse(node.left, p, q, ans) ? 1 : 0;
        int right = traverse(node.right, p, q, ans) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (mid + left + right >= 2) ans[0] = node;
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[]{null};
        traverse(root, p, q, ans);
        return ans[0];
    }


}
