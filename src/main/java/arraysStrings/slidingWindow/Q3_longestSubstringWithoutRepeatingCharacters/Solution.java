package arraysStrings.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int longest = 0;
        Map<Character, Integer> seenMap = new HashMap<>();

        for(int right=0; right<charArray.length;right++){
            Character currentChar = charArray[right];
            Integer prev = seenMap.get(currentChar);
            if(prev !=null && prev >= left){
                left = prev + 1;
            }
            seenMap.put(currentChar, right);
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}