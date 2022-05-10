package treeGraphs.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InOrderTraversalReversed_DFSTest {

    InOrderTraversalReversed_DFS inOrderTraversalReversed_dfs;

    @BeforeEach
    void beforeEach() {
        inOrderTraversalReversed_dfs = new InOrderTraversalReversed_DFS();
    }

    @Test
    void bst_nonIncreasingOrder() {
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

        List<Integer> actualAnswer = inOrderTraversalReversed_dfs.inOrderTraversalReversed(n8);
        List<Integer> expectedAnswer = List.of(14, 13, 10, 8, 7, 6, 4, 3, 1);
        assertEquals(expectedAnswer, actualAnswer);
    }
}