package twoPointers.prefixSum.Q1480_running_sum_1d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q1480_running_sum_1dTest {

    @Test
    void methodName() {
        Q1480_running_sum_1d solution = new Q1480_running_sum_1d();
        int[] input = new int[]{1, 2, 3, 4};
        int[] result = solution.runningSum(input);
        assertArrayEquals(new int[]{1, 3, 6, 10}, result);
    }
}