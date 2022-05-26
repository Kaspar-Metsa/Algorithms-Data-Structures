package treeGraphs.Q107_binaryTreeLevelOrderTraversal2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q107_binaryTreeLevelOrderTraversal2_BFSTest {

    Q107_binaryTreeLevelOrderTraversal2_BFS q107_binaryTreeLevelOrderTraversal2_bfs;

    @BeforeEach
    void beforeEach() {
        q107_binaryTreeLevelOrderTraversal2_bfs = new Q107_binaryTreeLevelOrderTraversal2_BFS();
    }

    @Test
    void test1() {
    /*
             3
           /  \
          9   20
             / \
            15  7
    */
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        List<List<Integer>> actualAnswer = q107_binaryTreeLevelOrderTraversal2_bfs.levelOrderBottom(n3);

        List<Integer> L1 = new ArrayList<>(List.of(3));
        List<Integer> L2 = new ArrayList<>(Arrays.asList(9, 20));
        List<Integer> L3 = new ArrayList<>(Arrays.asList(15, 7));

        List<List<Integer>> expectedAnswer = new ArrayList<>(Arrays.asList(L3, L2, L1));

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void test2() {
        TreeNode n1 = new TreeNode(1);

        List<List<Integer>> actualAnswer = q107_binaryTreeLevelOrderTraversal2_bfs.levelOrderBottom(n1);

        List<Integer> L1 = new ArrayList<>(Arrays.asList(1));

        List<List<Integer>> expectedAnswer = new ArrayList<>(Arrays.asList(L1));

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    void test3() {
        List<List<Integer>> actualAnswer = q107_binaryTreeLevelOrderTraversal2_bfs.levelOrderBottom(null);

        List<Integer> L1 = new ArrayList<>();

        List<List<Integer>> expectedAnswer = new ArrayList<>();

        assertEquals(expectedAnswer, actualAnswer);
    }
}