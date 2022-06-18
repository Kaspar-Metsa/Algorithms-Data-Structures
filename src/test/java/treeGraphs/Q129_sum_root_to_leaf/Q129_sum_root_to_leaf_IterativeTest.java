package treeGraphs.Q129_sum_root_to_leaf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q129_sum_root_to_leaf_IterativeTest {
    Q129_sum_root_to_leaf_Iterative q129_sum_root_to_leafBFS;

    @BeforeEach
    void beforeEach() {
        q129_sum_root_to_leafBFS = new Q129_sum_root_to_leaf_Iterative();
    }

    /*
             1
           /  \
          2   3
         / \ / \
        4  5 6  7
    */
    @Test
    void onePath() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        int actualAnswer = q129_sum_root_to_leafBFS.sumNumbers(n1);
        int expectedAnswer = 124 + 125 + 136 + 137;
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
             1
           /  \
          2   3
         / \
        4  5
       / \
      6  7
     /\
    8  9

*/
    @Test
    void skewedPath() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n4.left = n6;
        n4.right = n7;

        n6.left = n8;
        n6.right = n9;

        int actualAnswer = q129_sum_root_to_leafBFS.sumNumbers(n1);
        int expectedAnswer = 12468 + 12469 + 1247 + 125 + 13;
        assertEquals(expectedAnswer, actualAnswer);
    }
}