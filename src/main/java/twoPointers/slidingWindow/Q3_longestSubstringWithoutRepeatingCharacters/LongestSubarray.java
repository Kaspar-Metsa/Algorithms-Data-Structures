package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

public class LongestSubarray {
    /*
        Test case#1
            input 11001111
            output 4
        Test case#2
            input 1111100011
            output 5
    */
    public int longestSubArray(Integer[] input) {
        int result = 0;
        int freq = 0;
        if (input[0] == 1) {
            freq++;
            result = 1;
        }

        int left = 0;
        int right = 0;

        while (right < input.length - 1) {
            if (freq == right - left + 1) { //If the number of elements that are in subarray is the number of 1s
                result = Math.max(result, right - left + 1);
                right++;
                if (input[right] == 1) {
                    freq++;
                }

            } else {
                if (input[left] == 1) {
                    freq--;
                }
                left++;
                right++;
                if (input[right] == 1) {
                    freq++;
                }
            }
        }
        if (freq == right - left + 1) {
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}


//    int n = s.length();
//
//    int res = 0;
//    int freq1 = 0;
//if (s[0] == '1') freq1++;
//
//        int left = 0, right = 0;
//
//        while (right < n - 1) {
//        if (freq1 == right - left + 1) {
//        cout << left << " " << right << endl;
//        res = max(res, right - left + 1);
//        right++;
//        if (s[right] == '1') freq1++;
//        }
//        else {
//        if (s[left] == '1') freq1--;
//        left++;
//        right++;
//        if (s[right] == '1') freq1++;
//        }
//        }
//        cout << res << endl;
//
//        }