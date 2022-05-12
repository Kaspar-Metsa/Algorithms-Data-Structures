package treeGraphs.Q235_lowestCommonAncestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import treeGraphs.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q235_lowestCommonAncestor_BFSTest {

    Q235_lowestCommonAncestor_BFS q235_lowestCommonAncestor_bfs;

    @BeforeEach
    void beforeEach() {
        q235_lowestCommonAncestor_bfs = new Q235_lowestCommonAncestor_BFS();
    }

    @Test
    void test1() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n2;
        n2.left = n0;
        n2.right = n4;
        n4.right = n5;
        n4.left = n3;

        n6.right = n8;
        n8.left = n7;
        n8.right = n9;


        TreeNode actual = q235_lowestCommonAncestor_bfs.lowestCommonAncestor(n6, n2, n8);
        assertEquals(n6, actual);
    }

    @Test
    void test2() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n2;
        n2.left = n0;
        n2.right = n4;
        n4.right = n5;
        n4.left = n3;

        n6.right = n8;
        n8.left = n7;
        n8.right = n9;


        TreeNode actual = q235_lowestCommonAncestor_bfs.lowestCommonAncestor(n6, n2, n4);
        assertEquals(n2, actual);
    }

    @Test
    void test2_2nodes() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        n0.right = n1;
        TreeNode actual = q235_lowestCommonAncestor_bfs.lowestCommonAncestor(n0, n0, n1);
        assertEquals(n0, actual);
    }
}