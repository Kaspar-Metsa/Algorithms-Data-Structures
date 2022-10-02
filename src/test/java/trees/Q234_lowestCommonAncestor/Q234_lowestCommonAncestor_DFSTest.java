package trees.Q234_lowestCommonAncestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q234_lowestCommonAncestor_DFSTest {

    Q234_lowestCommonAncestor_DFS q234_lowestCommonAncestor_dfs;

    @BeforeEach
    void beforeEach() {
        q234_lowestCommonAncestor_dfs = new Q234_lowestCommonAncestor_DFS();
    }

    /*

             1
           /  \
          2   3
         / \ / \
        4  5 6  7
       /
      8

    */
    @Test
    void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;

        TreeNode actualLCA = q234_lowestCommonAncestor_dfs.lowestCommonAncestor(n1, n8, n5);
        assertEquals(n2, actualLCA);
    }
}