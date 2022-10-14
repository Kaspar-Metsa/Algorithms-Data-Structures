package twoPointers.slidingWindow.LongestSubstringContainaingExactlyKDistinct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringContainaingExactlyKDistinctTest {
    /*
        Find the length of the longest substring of a given string containing exactly k distinct characters

        Test case#1
            input "alkasjdocjcvjoenfeew", k=4
            output 7 ("ocjcvjo")
        Test case#2
            input "aab", k=3
            output 0 ("")
        Test case#3
            input "", k=1
            output 0 ("")
        Test case#4
            input "abc", k=1
            output 1 ("a" OR "b" OR "c")
    */
    @Test
    void test1() {
        LongestSubstringContainaingExactlyKDistinct solution = new LongestSubstringContainaingExactlyKDistinct();
        int result = solution.longestSubstringContainingKDistinct("alkasjdocjcvjoenfeew", 4);
        assertEquals(7, result);
    }

    @Test
    void test2() {
        LongestSubstringContainaingExactlyKDistinct solution = new LongestSubstringContainaingExactlyKDistinct();
        int result = solution.longestSubstringContainingKDistinct("aab", 3);
        assertEquals(0, result);
    }

    @Test
    void test3() {
        LongestSubstringContainaingExactlyKDistinct solution = new LongestSubstringContainaingExactlyKDistinct();
        int result = solution.longestSubstringContainingKDistinct("", 1);
        assertEquals(0, result);
    }

    @Test
    void test4() {
        LongestSubstringContainaingExactlyKDistinct solution = new LongestSubstringContainaingExactlyKDistinct();
        int result = solution.longestSubstringContainingKDistinct("abc", 1);
        assertEquals(1, result);
    }
}