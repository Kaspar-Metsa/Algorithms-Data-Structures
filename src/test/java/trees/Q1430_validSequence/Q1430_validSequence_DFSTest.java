package trees.Q1430_validSequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q1430_validSequenceDFSTest {

    Q1430_validSequence_DFS q1430_validSequenceDFS;

    @BeforeEach
    void beforeEach() {
        q1430_validSequenceDFS = new Q1430_validSequence_DFS();
    }

    /*
             1
           /  \
          2   3
         / \ / \
        4  5 6  7
    */
    @Test
    void happyCase() {
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

        int[] targetArray = new int[]{1, 2, 4};

        boolean actualAnswer = q1430_validSequenceDFS.isValidSequence(n1, targetArray);
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
         8
           \
           8b
            \
            9
           /
          5
         /  \
       7     3
        \    /
        8c  2
        arr=[8,8,9,5,3,2]


    */
    @Test
    void backtracking() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n8b = new TreeNode(8);
        TreeNode n8c = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n8.right = n8b;
        n8b.right = n9;
        n9.left = n5;
        n5.left = n7;
        n5.right = n3;
        n7.right = n8c;
        n3.left = n2;


        int[] targetArray = new int[]{8, 8, 9, 5, 3, 2};

        boolean actualAnswer = q1430_validSequenceDFS.isValidSequence(n8, targetArray);
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, actualAnswer);
    }
}