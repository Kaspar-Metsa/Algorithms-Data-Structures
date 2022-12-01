package twoPointers.prefixSum.Q724_find_pivot_index;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q724_find_pivot_indexTest {

    @Test
    void test1() {
        Q724_find_pivot_index solution = new Q724_find_pivot_index();
        int[] input = new int[]{1, 7, 3, 6, 5, 6};
        int result = solution.pivotIndex(input);
        assertEquals(3, result);
    }

    @Test
    void test2() {
        Q724_find_pivot_index solution = new Q724_find_pivot_index();
        int[] input = new int[]{1, 2, 3};
        int result = solution.pivotIndex(input);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        Q724_find_pivot_index solution = new Q724_find_pivot_index();
        int[] input = new int[]{2, 1, -1};
        int result = solution.pivotIndex(input);
        assertEquals(0, result);
    }
}