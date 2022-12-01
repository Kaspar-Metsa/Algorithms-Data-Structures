package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q35_Search_Insert_PositionTest {

    @Test
    void test1() {
        Q35_Search_Insert_Position solution = new Q35_Search_Insert_Position();
        int[] inputNums = new int[]{1, 3, 5, 6};
        int result = solution.searchInsert(inputNums, 5);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        Q35_Search_Insert_Position solution = new Q35_Search_Insert_Position();
        int[] inputNums = new int[]{1, 3, 5, 6};
        int result = solution.searchInsert(inputNums, 2);
        assertEquals(1, result);
    }

    @Test
    void test3() {
        Q35_Search_Insert_Position solution = new Q35_Search_Insert_Position();
        int[] inputNums = new int[]{1, 3, 5, 6};
        int result = solution.searchInsert(inputNums, 7);
        assertEquals(4, result);
    }
}