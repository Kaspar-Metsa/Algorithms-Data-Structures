package treeGraphs.Q199_rightSideView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q199_rightSideView_BFSTest {

    Q199_rightSideView_BFS q199_rightSideView_bfs;

    @BeforeEach
    void beforeEach() {
        q199_rightSideView_bfs = new Q199_rightSideView_BFS();
    }

    @Test
    void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

        List<Integer> actualAnswer = q199_rightSideView_bfs.rightSideView_ReverseLevelOrderWithPeek(n1);
        assertEquals(Arrays.asList(1, 3, 4), actualAnswer);
    }

    @Test
    void leftSkewedTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;

        List<Integer> actualAnswer = q199_rightSideView_bfs.rightSideView_ReverseLevelOrderWithPeek(n1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), actualAnswer);
    }

    @Test
    void rightSkewedTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;

        List<Integer> actualAnswer = q199_rightSideView_bfs.rightSideView_ReverseLevelOrderWithPeek(n1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), actualAnswer);
    }

    @Test
    void emptyTree() {
        TreeNode n1 = null;
        List<Integer> actualAnswer = q199_rightSideView_bfs.rightSideView_ReverseLevelOrderWithPeek(n1);
        assertEquals(new ArrayList<>(), actualAnswer);
    }
}