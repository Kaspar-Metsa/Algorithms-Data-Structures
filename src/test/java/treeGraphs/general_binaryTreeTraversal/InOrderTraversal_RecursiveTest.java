package treeGraphs.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InOrderTraversal_RecursiveTest {

    InOrderTraversal_Recursive inOrderTraversal_recursive;

    @BeforeEach
    void beforeEach() {
        inOrderTraversal_recursive = new InOrderTraversal_Recursive();
    }

    /*
                1
            /       \
           2         3
         /  \      /   \
        4   5     6     7
      / \  / \   / \   /\
     8  9 10 11 12 13 14 15

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
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        List<Integer> actualAnswer = inOrderTraversal_recursive.inOrderTraversal(n1);
        List<Integer> expectedAnswer = List.of(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15);
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

        List<Integer> actualAnswer = inOrderTraversal_recursive.inOrderTraversal(n8);
        List<Integer> expectedAnswer = List.of(1, 3, 4, 6, 7, 8, 10, 13, 14);
        assertEquals(expectedAnswer, actualAnswer);
    }


    @Test
    void test1_reversed() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        List<Integer> actualAnswer = inOrderTraversal_recursive.inOrderTraversalReversed(n1);
        List<Integer> expectedAnswer = List.of(15, 7, 14, 3, 13, 6, 12, 1, 11, 5, 10, 2, 9, 4, 8);
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void bst_nonDecreasingOrder_reversed() {
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

        List<Integer> actualAnswer = inOrderTraversal_recursive.inOrderTraversalReversed(n8);
        List<Integer> expectedAnswer = List.of(14, 13, 10, 8, 7, 6, 4, 3, 1);
        assertEquals(expectedAnswer, actualAnswer);
    }
}