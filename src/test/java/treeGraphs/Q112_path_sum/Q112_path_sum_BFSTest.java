package treeGraphs.Q112_path_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q112_path_sum_BFSTest {

    Q112_path_sum_BFS q112_path_sum_bfs;

    @BeforeEach
    void beforeEach() {
        q112_path_sum_bfs = new Q112_path_sum_BFS();
    }

    /*
             1
           /  \
          4    8
         /   / \
       11   13  4_b
      /  \       \
     7    2       1_b
    */
    @Test
    void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4_b = new TreeNode(4);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1_b = new TreeNode(1);

        n1.left = n4;
        n1.right = n8;

        n4.left = n11;
        n8.left = n13;
        n8.right = n4_b;

        n11.left = n7;
        n11.right = n2;
        n4_b.right = n1_b;


        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 22);
        assertTrue(actualResult);
    }

    /*
         1
       /  \
      2    3
    */
    @Test
    void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 5);
        assertFalse(actualResult);
    }


    /*
     null
    */
    @Test
    void test3() {
        TreeNode n1 = null;

        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 0);
        assertFalse(actualResult);
    }

    /*
     1
   /
  2
 /
3
*/
    @Test
    void test4() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n2.left = n3;

        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 6);
        assertTrue(actualResult);
    }

    /*
               1
           /      \
          4        8
         /      /    \
       11      13     4_b
      /  \   /   \    /  \
     7    2 15    14 16   1_b
    */
    @Test
    void test5() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4_b = new TreeNode(4);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1_b = new TreeNode(1);
        TreeNode n14 = new TreeNode(1);
        TreeNode n15 = new TreeNode(1);
        TreeNode n16 = new TreeNode(1);

        n1.left = n4;
        n1.right = n8;

        n4.left = n11;
        n8.left = n13;
        n8.right = n4_b;

        n11.left = n7;
        n11.right = n2;
        n4_b.right = n1_b;


        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 22);
        assertTrue(actualResult);
    }


    /*
             1
       /          \
      2             3
     / \         /    \
   4    5       6      7
  /\   / \     / \     /\
 7  8 9   10  11 12  13 14
*/
    @Test
    void test6() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n4.left = n7;
        n4.right = n8;
        n5.left = n9;
        n5.right = n10;
        n6.left = n11;
        n6.right = n12;
        n7.left = n13;
        n7.right = n14;

        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 1231231);
        assertFalse(actualResult);
    }


    /*
            1
           /\
          2  3
         / \
        4   5
       / \
      6   7
     / \
    8   9
*/
    @Test
    void test7() {
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
        n4.right = n7;

        n6.left = n8;
        n6.right = n9;

        boolean actualResult = q112_path_sum_bfs.hasPathSum(n1, 6123123);
        assertFalse(actualResult);
    }


}