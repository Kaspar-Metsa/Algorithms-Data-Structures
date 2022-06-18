package treeGraphs.Q113_path_sum_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q113_path_sum_2_DFSTest {

    Q113_path_sum_2_DFS q113_path_sum_2_dfs;

    @BeforeEach
    void beforeEach() {
        q113_path_sum_2_dfs = new Q113_path_sum_2_DFS();
    }

    /*
             1
           /  \
          2   3
         / \ / \
        4  5 6  7
    */
    @Test
    void onePath() {
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

        List<List<Integer>> actualAnswer = q113_path_sum_2_dfs.pathSum(n1, 7);
        List<List<Integer>> expectedAnswer = List.of(List.of(1, 2, 4));
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
          1
       /    \
      2      3
     / \   /  \
    4  4_a 3_a  3_b
*/
    @Test
    void allPaths() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n3_a = new TreeNode(3);
        TreeNode n3_b = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n4_a = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n4_a;

        n3.left = n3_a;
        n3.right = n3_b;

        List<List<Integer>> actualAnswer = q113_path_sum_2_dfs.pathSum(n1, 7);
        List<List<Integer>> expectedAnswer = List.of(List.of(1, 2, 4), List.of(1, 2, 4), List.of(1, 3, 3), List.of(1, 3, 3));
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
          1
       /    \
      2      3
    */
    @Test
    void noPaths() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        List<List<Integer>> actualAnswer = q113_path_sum_2_dfs.pathSum(n1, 5);
        List<List<Integer>> expectedAnswer = new ArrayList<>();
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*
         1
       /
      2
     /
    3

*/
    @Test
    void linkedListPath() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n2.left = n3;

        List<List<Integer>> actualAnswer = q113_path_sum_2_dfs.pathSum(n1, 6);
        List<List<Integer>> expectedAnswer = List.of(List.of(1, 2, 3));
        assertEquals(expectedAnswer, actualAnswer);
    }
}