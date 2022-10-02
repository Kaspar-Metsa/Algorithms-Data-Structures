package trees.Q543_diameterOfBinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q543_diameterOfBinaryTree_DFSTest {

    Q543_diameterOfBinaryTree_DFS q543DiameterOfBinaryTree;

    @BeforeEach
    void beforeEach() {
        q543DiameterOfBinaryTree = new Q543_diameterOfBinaryTree_DFS();
    }

    /*
             1
           /   \
          2    3
         / \  / \
        4  5  6  7
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

        int actualAnswer = q543DiameterOfBinaryTree.diameterOfBinaryTree(n1);
        int expectedAnswer = 4;
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
         1
       /
      2
*/
    @Test
    void skewedCase() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

        n1.left = n2;

        int actualAnswer = q543DiameterOfBinaryTree.diameterOfBinaryTree(n1);
        int expectedAnswer = 1;
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
         1
       /  \
      2    3
     / \
    4  5
   /    \
  6     7
 /       \
8         9
*/
    @Test
    void diameterNotPassingThroughRoot() {
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
        n5.right = n7;

        n6.left = n8;
        n7.right = n9;

        int actualAnswer = q543DiameterOfBinaryTree.diameterOfBinaryTree(n1);
        int expectedAnswer = 6;
        assertEquals(expectedAnswer, actualAnswer);
    }
}