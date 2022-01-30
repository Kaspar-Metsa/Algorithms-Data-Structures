package arraysStrings.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        assertEquals(solution.lengthOfLongestSubstring("abccabb"),3);
        assertEquals(solution.lengthOfLongestSubstring("cccccc"),1);
        assertEquals(solution.lengthOfLongestSubstring(""),0);
        assertEquals(solution.lengthOfLongestSubstring("abcbda"),4);
    }
}