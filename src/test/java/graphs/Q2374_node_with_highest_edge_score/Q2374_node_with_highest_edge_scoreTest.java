package graphs.Q2374_node_with_highest_edge_score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q2374_node_with_highest_edge_scoreTest {

    @Test
    void test1() {
        int[] edges = new int[]{1, 0, 0, 0, 0, 7, 7, 5};
        Q2374_node_with_highest_edge_score q2374_node_with_highest_edge_score = new Q2374_node_with_highest_edge_score();
        int actual = q2374_node_with_highest_edge_score.edgeScore(edges);
        assertEquals(7, actual);
    }

    @Test
    void test2() {
        int[] edges = new int[]{2, 0, 0, 2};
        Q2374_node_with_highest_edge_score q2374_node_with_highest_edge_score = new Q2374_node_with_highest_edge_score();
        int actual = q2374_node_with_highest_edge_score.edgeScore(edges);
        assertEquals(0, actual);
    }
}