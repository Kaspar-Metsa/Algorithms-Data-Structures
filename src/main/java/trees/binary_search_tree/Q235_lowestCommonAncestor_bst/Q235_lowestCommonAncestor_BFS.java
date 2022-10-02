package trees.binary_search_tree.Q235_lowestCommonAncestor_bst;

import trees.util.TreeNode;

public class Q235_lowestCommonAncestor_BFS {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }
}
