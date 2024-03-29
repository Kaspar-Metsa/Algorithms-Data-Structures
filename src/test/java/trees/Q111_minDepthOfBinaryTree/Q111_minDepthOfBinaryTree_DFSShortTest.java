package trees.Q111_minDepthOfBinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q111_minDepthOfBinaryTree_DFSShortTest {

    Q111_minDepthOfBinaryTree_DFSShort q111_minDepthOfBinaryTree_dfsShort;

    @BeforeEach
    void beforeEach() {
        q111_minDepthOfBinaryTree_dfsShort = new Q111_minDepthOfBinaryTree_DFSShort();
    }

    @Test
    void test1() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left=n9;
        n3.right=n20;
        n20.left=n15;
        n20.right=n7;

        int actualAnswer = q111_minDepthOfBinaryTree_dfsShort.minDepth(n3);
        assertEquals(2, actualAnswer);
    }
    @Test
    void test2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n2.left=n3;
        n3.left=n4;
        n4.left=n5;
        n5.left=n6;

        int actualAnswer = q111_minDepthOfBinaryTree_dfsShort.minDepth(n2);
        assertEquals(5, actualAnswer);
    }

    @Test
    void test1_alternative() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left=n9;
        n3.right=n20;
        n20.left=n15;
        n20.right=n7;

        int actualAnswer = q111_minDepthOfBinaryTree_dfsShort.minDepth(n3);
        assertEquals(2, actualAnswer);
    }
    @Test
    void test2_alternative() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n2.left=n3;
        n3.left=n4;
        n4.left=n5;
        n5.left=n6;

        int actualAnswer = q111_minDepthOfBinaryTree_dfsShort.minDepth(n2);
        assertEquals(5, actualAnswer);
    }
}