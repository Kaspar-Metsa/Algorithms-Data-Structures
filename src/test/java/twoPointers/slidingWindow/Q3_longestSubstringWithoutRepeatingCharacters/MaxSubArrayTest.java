package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArrayTest {

    @Test
    void maxSubarray() {
        MaxSubArray maxSubArray = new MaxSubArray();
        Integer[] input = new Integer[]{1, 10, -5, 4, 7};
        int length = 3;
        int answer = maxSubArray.maxSubarray(input, length);
        assertEquals(17, answer);
    }
}