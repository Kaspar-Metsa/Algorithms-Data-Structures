package graphs.Q2360_longest_cycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q2360_longest_cycleTest {

    @Test
    void test1() {
        Q2360_longest_cycle solution = new Q2360_longest_cycle();
        int[] edges = new int[]{3, 3, 4, 2, 3};
        int result = solution.longestCycle(edges);
        assertEquals(3, result);
    }

    @Test
    void test2() {
        Q2360_longest_cycle solution = new Q2360_longest_cycle();
        int[] edges = new int[]{2, -1, 3, 1};
        int result = solution.longestCycle(edges);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        Q2360_longest_cycle solution = new Q2360_longest_cycle();
        int[] edges = new int[]{1, 2, 0, 4, 5, 6, 3, 8, 9, 7};
        int result = solution.longestCycle(edges);
        assertEquals(4, result);
    }
}