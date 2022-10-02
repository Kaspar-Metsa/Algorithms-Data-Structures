package trees.Q129_sum_root_to_leaf;

import trees.util.TreeNode;

/*

         1
       /  \
      2    3
     / \  / \
    4  5 6  7

    root=1,2
    rootToLeaf=0
    currNumber=0*10+1=1
    steps=2
    predecessor=2,5
    predecessor.right=1

    5
     \
      1

*/

public class Q129_sum_root_to_leaf_Morris {
    public int sumNumbers(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        int steps;
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    ++steps;
                }
                if (predecessor.right == null) {
                    currNumber = currNumber * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (predecessor.left == null) {
                        rootToLeaf += currNumber;
                    }
                    for (int i = 0; i < steps; ++i) {
                        currNumber /= 10;
                    }
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                currNumber = currNumber * 10 + root.val;
                if (root.right == null) {
                    rootToLeaf += currNumber;
                }
                root = root.right;
            }
        }
        return rootToLeaf;
    }
}
