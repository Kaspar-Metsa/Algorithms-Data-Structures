package treeGraphs.Q104_maxDepthOfBinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class Q104_maxDepthOfBinaryTree_DFSIterativeTest {

    Q104_maxDepthOfBinaryTree_DFSIterative q104_maxDepthOfBinaryTree_dfsIterative;

    @BeforeEach
    void beforeEach() {
        q104_maxDepthOfBinaryTree_dfsIterative = new Q104_maxDepthOfBinaryTree_DFSIterative();
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

        int actualAnswer = q104_maxDepthOfBinaryTree_dfsIterative.maxDepth(n3);
        int expectedAnswer = 3;

        assertEquals(expectedAnswer, actualAnswer);
    }
    @Test
    void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

        n1.left=n2;

        int actualAnswer = q104_maxDepthOfBinaryTree_dfsIterative.maxDepth(n1);
        int expectedAnswer = 2;

        assertEquals(expectedAnswer, actualAnswer);
    }
    @Test
    void emptyTree() {
        TreeNode n1 = null;

        int actualAnswer = q104_maxDepthOfBinaryTree_dfsIterative.maxDepth(n1);
        int expectedAnswer = 0;

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void oneNode() {
        TreeNode n1 = new TreeNode(1);

        int actualAnswer = q104_maxDepthOfBinaryTree_dfsIterative.maxDepth(n1);
        int expectedAnswer = 1;

        assertEquals(expectedAnswer, actualAnswer);
    }
}