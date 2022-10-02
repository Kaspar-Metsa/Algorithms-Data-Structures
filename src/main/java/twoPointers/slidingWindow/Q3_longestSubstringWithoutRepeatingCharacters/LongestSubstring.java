package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class LongestSubstring {
    //Brute force
//    public int lengthOfLongestSubstring(String s) {
//        char[] charArray = s.toCharArray();
//        int left = 0;
//        int longest = 0;
//        Map<Character, Integer> seenMap = new HashMap<>();
//
//        for (int right = 0; right < charArray.length; right++) {
//            Character currentChar = charArray[right];
//            Integer prev = seenMap.get(currentChar);
//            if (prev != null && prev >= left) {
//                left = prev + 1;
//            }
//            seenMap.put(currentChar, right);
//            longest = Math.max(longest, right - left + 1);
//        }
//        return longest;
//    }

    //Optimal
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r, 0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}