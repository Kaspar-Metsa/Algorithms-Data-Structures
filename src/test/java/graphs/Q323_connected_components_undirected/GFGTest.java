package graphs.Q323_connected_components_undirected;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GFGTest {

    @Test
    void test1() {
        int result = GFG.printAnswer(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        assertEquals(2, result);
    }

    @Test
    void test2() {
        Q323_connected_components_undirected solution = new Q323_connected_components_undirected();
        int result = solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        assertEquals(1, result);
    }

    @Test
    void test3() {
        Q323_connected_components_undirected solution = new Q323_connected_components_undirected();
        int result = solution.countComponents(4, new int[][]{{2, 3}, {1, 2}, {1, 3}});
        assertEquals(2, result);
    }

    @Test
    void test4() {
        int result = GFG.printAnswer(4, new int[][]{{0, 1}, {2, 3}, {1, 2}});
        assertEquals(1, result);
    }

    @Test
    void test5() {
        int result = GFG.printAnswer(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        assertEquals(1, result);
    }
}