package treeGraphs.Q102_binaryTreeLevelOrderTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treeGraphs.general_binaryTreeTraversal.general_binaryTreeTraversal_BFS;
import treeGraphs.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q102_binaryTreeLevelOrderTraversal_BFSTest {

    Q102_binaryTreeLevelOrderTraversal_BFS q102_binaryTreeLevelOrderTraversal_bfs;

    @BeforeEach
    void beforeEach() {
        q102_binaryTreeLevelOrderTraversal_bfs = new Q102_binaryTreeLevelOrderTraversal_BFS();
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

        List<List<Integer>> actualAnswer = q102_binaryTreeLevelOrderTraversal_bfs.levelOrder(n3);

        List<Integer> L1 = new ArrayList<>(List.of(3));
        List<Integer> L2 = new ArrayList<>(Arrays.asList(9,20));
        List<Integer> L3 = new ArrayList<>(Arrays.asList(15,7));

        List<List<Integer>> expectedAnswer = new ArrayList<>(Arrays.asList(L1, L2, L3));

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void test2() {
        TreeNode n1 = new TreeNode(1);

        List<List<Integer>> actualAnswer = q102_binaryTreeLevelOrderTraversal_bfs.levelOrder(n1);

        List<Integer> L1 = new ArrayList<>(Arrays.asList(1));

        List<List<Integer>> expectedAnswer = new ArrayList<>(Arrays.asList(L1));

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void test3() {
        List<List<Integer>> actualAnswer = q102_binaryTreeLevelOrderTraversal_bfs.levelOrder(null);

        List<Integer> L1 = new ArrayList<>();

        List<List<Integer>> expectedAnswer = new ArrayList<>();

        assertEquals(expectedAnswer, actualAnswer);
    }
}