package trees.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreOrderTraversal_Iterative_Q144Test {

    PreOrderTraversal_Iterative_Q144 preOrderTraversal_iterative_q144;

    @BeforeEach
    void beforeEach() {
        preOrderTraversal_iterative_q144 = new PreOrderTraversal_Iterative_Q144();
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

        List<Integer> actualAnswer = preOrderTraversal_iterative_q144.preOrderTraversal(n1);
        List<Integer> expectedAnswer = List.of(1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15);
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

        List<Integer> actualAnswer = preOrderTraversal_iterative_q144.preorderTraversalReversed(n1);
        List<Integer> expectedAnswer = List.of(1, 3, 7, 15, 14, 6, 13, 12, 2, 5, 11, 10, 4, 9, 8);
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void test_empty() {
        TreeNode n1 = null;

        List<Integer> actualAnswer = preOrderTraversal_iterative_q144.preOrderTraversal(n1);
        List<Integer> expectedAnswer = List.of();
        assertEquals(expectedAnswer, actualAnswer);
    }
}