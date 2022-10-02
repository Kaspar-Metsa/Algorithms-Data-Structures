package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubarrayTest {

    @Test
    void longestSubArray() {
        LongestSubarray solution = new LongestSubarray();
        Integer[] input = new Integer[]{1, 1, 0, 0, 1, 1, 1, 1};
        int result = solution.longestSubArray(input);
        assertEquals(4, result);
    }
}