package treeGraphs.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class General_inOrderTraversal_DFSTest {
    InOrderTraversal_DFS general_inOrderTraversal_dfs;

    @BeforeEach
    void beforeEach() {
        general_inOrderTraversal_dfs = new InOrderTraversal_DFS();
    }

    /*
             1
           /  \
          2   3
         / \ / \
        4  5 6  7
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

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        List<Integer> actualAnswer = general_inOrderTraversal_dfs.inOrderTraversal(n1);
        List<Integer> expectedAnswer = List.of(4, 2, 5, 1, 6, 3, 7);
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void bst_nonDecreasingOrder() {
            /*
             8
           /  \
          3   10
         / \   \
        1  6    14
          / \  /
         4  7 13
    */
        TreeNode n8 = new TreeNode(8);
        TreeNode n3 = new TreeNode(3);
        TreeNode n10 = new TreeNode(10);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n14 = new TreeNode(14);
        TreeNode n13 = new TreeNode(13);

        n8.left = n3;
        n3.left = n1;
        n3.right = n6;
        n6.left = n4;
        n6.right = n7;

        n8.right = n10;
        n10.right = n14;
        n14.left = n13;

        List<Integer> actualAnswer = general_inOrderTraversal_dfs.inOrderTraversal(n8);
        List<Integer> expectedAnswer = List.of(1, 3, 4, 6, 7, 8, 10, 13, 14);
        assertEquals(expectedAnswer, actualAnswer);
    }
}