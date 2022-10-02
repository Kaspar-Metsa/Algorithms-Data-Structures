package trees.Q103_binaryTreeZigzagLevelOrderTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q103_binaryTreeZigzagLevelOrderTraversal_BFSTest {


    Q103_binaryTreeZigzagLevelOrderTraversal_BFS q103_binaryTreeZigzagLevelOrderTraversal_bfs;

    @BeforeEach
    void beforeEach() {
        q103_binaryTreeZigzagLevelOrderTraversal_bfs = new Q103_binaryTreeZigzagLevelOrderTraversal_BFS();
    }

    @Test
    void regularTree() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left=n9;
        n3.right=n20;
        n20.left=n15;
        n20.right=n7;

        List<List<Integer>> actualListList = q103_binaryTreeZigzagLevelOrderTraversal_bfs.zigzagLevelOrder(n3);
        List<List<Integer>> expectedListList = Arrays.asList(Arrays.asList(3), Arrays.asList(20,9), Arrays.asList(15,7));
        assertEquals(expectedListList, actualListList);
    }
    @Test
    void skewedTree() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);

        n3.left=n9;
        n9.left=n20;

        List<List<Integer>> actualListList = q103_binaryTreeZigzagLevelOrderTraversal_bfs.zigzagLevelOrder(n3);
        List<List<Integer>> expectedListList = Arrays.asList(Arrays.asList(3), Arrays.asList(9), Arrays.asList(20));
        assertEquals(expectedListList, actualListList);
    }

    @Test
    void oneNode() {
        TreeNode n1 = new TreeNode(1);

        List<List<Integer>> actualListList = q103_binaryTreeZigzagLevelOrderTraversal_bfs.zigzagLevelOrder(n1);
        List<List<Integer>> expecedListList = Arrays.asList(Arrays.asList(1));
        assertEquals(expecedListList, actualListList);
    }
    @Test
    void noNode() {
        TreeNode n = null;

        List<List<Integer>> actualListList = q103_binaryTreeZigzagLevelOrderTraversal_bfs.zigzagLevelOrder(n);
        List<List<Integer>> expectedListList = Arrays.asList();
        assertEquals(expectedListList, actualListList);
    }
}