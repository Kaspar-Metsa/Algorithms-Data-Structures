package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q704_BasicBinarySearchTest {

    @Test
    void test1() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int[] inputArray = new int[]{-1001, -1000, -50, -10, -1, 0, 3, 5, 9, 12};
        int target = -50;
        int result = solution.search(inputArray, target);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int[] inputArray = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        int result = solution.search(inputArray, target);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        Q704_BasicBinarySearch solution = new Q704_BasicBinarySearch();
        int[] inputArray = new int[]{};
        int target = 2;
        int result = solution.search(inputArray, target);
        assertEquals(-1, result);
    }
}