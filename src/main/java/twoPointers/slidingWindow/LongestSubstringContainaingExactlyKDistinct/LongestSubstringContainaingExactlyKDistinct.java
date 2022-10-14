package twoPointers.slidingWindow.LongestSubstringContainaingExactlyKDistinct;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringContainaingExactlyKDistinct {
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
    public int longestSubstringContainingKDistinct(String input, int distinctCharCount) {
        if (input.length() == 0) return 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        for (int i = 0; distinctCharCount != map.size() && i < input.length() - 1; i++) {
            if (i != 0) {
                right++;
            }
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }
        if (map.size() < distinctCharCount) {
            return 0;
        }
        int left = 0;

        while (right < input.length() - 1) {
            if (map.size() == distinctCharCount) {
                result = Math.max(result, right - left + 1);
                right++;
                map.put(input.charAt(right), map.getOrDefault(input.charAt(right), 0) + 1);
            } else {
                if (map.get(input.charAt(left)) > 1) {
                    map.put(input.charAt(left), map.get(input.charAt(left)) - 1);
                } else if (map.get(input.charAt(left)) == 1) {
                    map.remove(input.charAt(left));
                }
                left++;
                right++;
                map.put(input.charAt(right), map.getOrDefault(input.charAt(right), 0) + 1);
            }
        }
        return result;
    }
}