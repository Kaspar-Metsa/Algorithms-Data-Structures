package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        LongestSubstring longestSubstring = new LongestSubstring();
//        assertEquals(solution.lengthOfLongestSubstring("abccabb"),3);
//        assertEquals(solution.lengthOfLongestSubstring("cccccc"),1);
//        assertEquals(solution.lengthOfLongestSubstring(""),0);
        assertEquals(longestSubstring.lengthOfLongestSubstring("abcbda"), 4);
    }
}