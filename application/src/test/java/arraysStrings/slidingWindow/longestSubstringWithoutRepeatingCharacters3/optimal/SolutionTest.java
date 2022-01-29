package arraysStrings.slidingWindow.longestSubstringWithoutRepeatingCharacters3.optimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("qq");
        assertEquals(1, length);
    }
}