package twoPointers.slidingWindow.Q485_maxConsecutiveOnes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q485_maxConsecutiveOnesTest {
    /*
        Test case#1
            input 11001111
            output 4
        Test case#2
            input 1111100011
            output 5
    */
    @Test
    void test1() {
        Q485_maxConsecutiveOnes solution = new Q485_maxConsecutiveOnes();
        int result = solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1, 1});
        assertEquals(4, result);
    }

    @Test
    void test2() {
        Q485_maxConsecutiveOnes solution = new Q485_maxConsecutiveOnes();
        int result = solution.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 0, 0, 0, 1, 1});
        assertEquals(5, result);
    }
}