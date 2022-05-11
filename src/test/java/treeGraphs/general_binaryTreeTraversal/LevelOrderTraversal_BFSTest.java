package treeGraphs.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelOrderTraversal_BFSTest {

    LevelOrderTraversal_BFS general_binaryTreeTraversal_bfs;

    @BeforeEach
    void beforeEach() {
        general_binaryTreeTraversal_bfs = new LevelOrderTraversal_BFS();
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

        List<Integer> actualAnswer = general_binaryTreeTraversal_bfs.generalTraversal(n1);
        List<Integer> expectedAnswer = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expectedAnswer, actualAnswer);
    }
}