package twoPointers.slidingWindow.Q167_2SumSorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q167_2SumSortedTest {

    @Test
    void methodName() {
        Q167_2SumSorted solution = new Q167_2SumSorted();
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(input, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }
}