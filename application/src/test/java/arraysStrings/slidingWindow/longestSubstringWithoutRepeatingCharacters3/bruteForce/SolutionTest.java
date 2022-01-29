package arraysStrings.slidingWindow.longestSubstringWithoutRepeatingCharacters3.bruteForce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("qq");
        assertEquals(length,2);
    }
}