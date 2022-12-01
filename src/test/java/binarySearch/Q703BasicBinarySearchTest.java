package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q703BasicBinarySearchTest {

    @Test
    void test1() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int result = solution.search(new int[]{-1, 0, 3, 5, 9, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 9);
        assertEquals(4, result);
    }

    @Test
    void test2() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int result = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int result = solution.search(new int[]{2, 5}, 5);
        assertEquals(1, result);
    }
}