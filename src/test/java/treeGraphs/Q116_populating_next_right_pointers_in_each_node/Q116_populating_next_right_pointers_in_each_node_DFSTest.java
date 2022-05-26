package treeGraphs.Q116_populating_next_right_pointers_in_each_node;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Q116_populating_next_right_pointers_in_each_node_DFSTest {

    Q116_populating_next_right_pointers_in_each_node_DFS q116_populating_next_right_pointers_in_each_node_dfs;

    @BeforeEach
    void beforeEach() {
        q116_populating_next_right_pointers_in_each_node_dfs = new Q116_populating_next_right_pointers_in_each_node_DFS();
    }

    /*
             1
           /  \
          2    3
         / \  / \
        4  5 6   7
    */
    @Test
    void test1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        Node actualResult = q116_populating_next_right_pointers_in_each_node_dfs.connect(n1);
        assertNull(actualResult.next);

        assertEquals(actualResult.left.next, n3);
        assertNull(actualResult.right.next);

        assertEquals(actualResult.left.left.next, n5);
        assertEquals(actualResult.left.right.next, n6);
        assertEquals(actualResult.right.left.next, n7);
        assertNull(actualResult.right.right.next);
    }

    @Test
    void test2() {
        Node n1 = null;
        Node actualResult = q116_populating_next_right_pointers_in_each_node_dfs.connect(n1);
        assertNull(actualResult);
    }
}