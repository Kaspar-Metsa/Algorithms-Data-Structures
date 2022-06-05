package treeGraphs.Q112_path_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q112_path_sum_DFSTest {
    Q112_path_sum_DFS q112_path_sum_dfs;

    @BeforeEach
    void beforeEach() {
        q112_path_sum_dfs = new Q112_path_sum_DFS();
    }

    /*
             1
           /  \
          4    8
         /   / \
       11   13  4_b
      /  \       \
     7    2       1_b
    */
    @Test
    void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4_b = new TreeNode(4);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1_b = new TreeNode(1);

        n1.left = n4;
        n1.right = n8;

        n4.left = n11;
        n8.left = n13;
        n8.right = n4_b;

        n11.left = n7;
        n11.right = n2;
        n4_b.right = n1_b;


        boolean actualResult = q112_path_sum_dfs.hasPathSum(n1, 22);
        assertTrue(actualResult);
    }

    /*
         1
       /  \
      2    3
    */
    @Test
    void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        boolean actualResult = q112_path_sum_dfs.hasPathSum(n1, 5);
        assertFalse(actualResult);
    }


    /*
     null
    */
    @Test
    void test3() {
        TreeNode n1 = null;

        boolean actualResult = q112_path_sum_dfs.hasPathSum(n1, 0);
        assertFalse(actualResult);
    }

}