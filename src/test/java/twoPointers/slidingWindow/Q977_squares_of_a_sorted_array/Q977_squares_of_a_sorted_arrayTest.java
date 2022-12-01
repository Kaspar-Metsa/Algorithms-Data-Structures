package twoPointers.slidingWindow.Q977_squares_of_a_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q977_squares_of_a_sorted_arrayTest {

    /*
    Test case#1
        input nums = [-4,-1,0,3,10]
        output [0,1,9,16,100]
    Test case#2
        input [-7,-3,2,3,11]
        output [4,9,9,49,121]
*/
    @Test
    void test1() {
        Q977_squares_of_a_sorted_array solution = new Q977_squares_of_a_sorted_array();
        int[] input = new int[]{-4, -1, 0, 3, 10};
        int[] result = solution.sortedSquares(input);
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, result);
    }

    @Test
    void test2() {
        Q977_squares_of_a_sorted_array solution = new Q977_squares_of_a_sorted_array();
        int[] input = new int[]{-7, -3, 2, 3, 11};
        int[] result = solution.sortedSquares(input);
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, result);
    }
}