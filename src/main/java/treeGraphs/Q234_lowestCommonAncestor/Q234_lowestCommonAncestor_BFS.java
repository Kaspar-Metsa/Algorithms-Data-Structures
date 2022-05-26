package treeGraphs.Q234_lowestCommonAncestor;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import treeGraphs.util.TreeNode;

public class Q234_lowestCommonAncestor_BFS {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var stack = new ArrayDeque<TreeNode>();
        var map = new HashMap<TreeNode, TreeNode>();
        map.put(root, null);
        stack.push(root);
        while (!(map.containsKey(p) && map.containsKey(q))) {
            var node = stack.pop();
            if (node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        var ancestors = new HashSet<TreeNode>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = map.get(q);
        return q;
    }
}
