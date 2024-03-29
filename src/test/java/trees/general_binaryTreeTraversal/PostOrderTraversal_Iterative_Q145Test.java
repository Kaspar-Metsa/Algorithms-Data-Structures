package trees.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostOrderTraversal_Iterative_Q145Test {

    PostOrderTraversal_Iterative_Q145 postOrderTraversal_iterative_q145;

    @BeforeEach
    void beforeEach() {
        postOrderTraversal_iterative_q145 = new PostOrderTraversal_Iterative_Q145();
    }

    /*
                  1
            /           \
           2             3
         /  \      /           \
        4   5     6             7
      / \  / \   / \            /\
     8  9 10 11 12 13         14 15
       /   \       / \        / \
      16   17     20  21     24 25
       \   /          / \    / \
       18 19         22 23  26 27
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
        TreeNode n16 = new TreeNode(16);
        TreeNode n17 = new TreeNode(17);
        TreeNode n18 = new TreeNode(18);
        TreeNode n19 = new TreeNode(19);
        TreeNode n20 = new TreeNode(20);
        TreeNode n21 = new TreeNode(21);
        TreeNode n22 = new TreeNode(22);
        TreeNode n23 = new TreeNode(23);
        TreeNode n24 = new TreeNode(24);
        TreeNode n25 = new TreeNode(25);
        TreeNode n26 = new TreeNode(26);
        TreeNode n27 = new TreeNode(27);

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

        n9.left = n16;
        n10.right = n17;

        n16.right = n18;

        n17.left = n19;

        n13.left = n20;
        n13.right = n21;

        n21.left = n22;
        n21.right = n23;

        n14.left = n24;
        n14.right = n25;

        n24.left = n26;
        n24.right = n27;


        List<Integer> actualAnswerOneStack = postOrderTraversal_iterative_q145.postOrderTraversal_OneStack(n1);
        List<Integer> expectedAnswer = List.of(8, 18, 16, 9, 4, 19, 17, 10, 11, 5, 2, 12, 20, 22, 23, 21, 13, 6, 26, 27, 24, 25, 14, 15, 7, 3, 1);
        assertEquals(expectedAnswer, actualAnswerOneStack);
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

        List<Integer> actualAnswerOneStack = postOrderTraversal_iterative_q145.postOrderTraversal_OneStack(n8);
        List<Integer> expectedAnswer = List.of(1, 4, 7, 6, 3, 13, 14, 10, 8);
        assertEquals(expectedAnswer, actualAnswerOneStack);
    }
}