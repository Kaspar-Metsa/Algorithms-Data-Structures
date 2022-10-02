package trees.binary_search_tree.Q98_validate_binary_search_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trees.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q98_validate_binary_search_tree_DFS_naiveTest {
    Q98_validate_binary_search_tree_DFS_naive q98_validate_binary_search_tree_dfs_naive;

    @BeforeEach
    void beforeEach() {
        q98_validate_binary_search_tree_dfs_naive = new Q98_validate_binary_search_tree_DFS_naive();
    }

    @Test
    void validDepth3() {
    /*
             6
           /   \
          4     8
         / \   / \
        3  5  7   9
    */
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n4;
        n4.left = n3;
        n4.right = n5;

        n6.right = n8;
        n8.left = n7;
        n8.right = n9;

        assertTrue(q98_validate_binary_search_tree_dfs_naive.isValidBST(n6));
    }

    @Test
    void validOneNode() {
        TreeNode n1 = new TreeNode(1);
        assertTrue(q98_validate_binary_search_tree_dfs_naive.isValidBST(n1));
    }

    @Test
    void validOneMaxIntegerNode() {
        TreeNode n1 = new TreeNode(2147483646);
        assertTrue(q98_validate_binary_search_tree_dfs_naive.isValidBST(n1));
    }

    @Test
    void notValidDuplicates() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        assertFalse(q98_validate_binary_search_tree_dfs_naive.isValidBST(n1));
    }

    @Test
    void notValidLeftSide_Depth2() {
    /*
             6
           /   \
          7     8
    */

        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n6.left = n7;
        n6.right = n8;

        assertFalse(q98_validate_binary_search_tree_dfs_naive.isValidBST(n6));
    }

    @Test
    void notValidRightSide_Depth2() {
    /*
             6
           /   \
          4     5
    */

        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n6.left = n4;
        n6.right = n5;

        assertFalse(q98_validate_binary_search_tree_dfs_naive.isValidBST(n6));
    }


    @Test
    void notValid_RightSideGrandChild_Depth7() {
    /*
             6
           /   \
          3     8
         / \   / \
        2  4  5   9
    */
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n3;
        n3.left = n2;
        n3.right = n4;

        n6.right = n8;
        n8.left = n5;
        n8.right = n9;

        assertFalse(q98_validate_binary_search_tree_dfs_naive.isValidBST(n6));
    }

    @Test
    void notValid_LeftSideGrandChild_Depth7() {
    /*
             6
           /   \
          3     9
         / \   / \
        2  7  8   10
    */
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n6.left = n3;
        n3.left = n2;
        n3.right = n7;

        n6.right = n9;
        n9.left = n8;
        n9.right = n10;

        assertFalse(q98_validate_binary_search_tree_dfs_naive.isValidBST(n6));
    }
}