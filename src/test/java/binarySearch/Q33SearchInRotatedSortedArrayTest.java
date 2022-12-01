package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q33SearchInRotatedSortedArrayTest {

    @Test
    void test1() {
        Q33_SearchInRotatedSortedArray solution = new Q33_SearchInRotatedSortedArray();
        int result = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assertEquals(4, result);
    }

    @Test
    void test2() {
        Q33_SearchInRotatedSortedArray solution = new Q33_SearchInRotatedSortedArray();
        int result = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        Q33_SearchInRotatedSortedArray solution = new Q33_SearchInRotatedSortedArray();
        int result = solution.search(new int[]{1}, 0);
        assertEquals(-1, result);
    }
}