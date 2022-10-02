package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

public class MaxSubArray {

//BRUTE FORCE
//    input [1,10,-5,4,7]
//    subArrayLength 3
//    output 9
//    public int maxSubarray(Integer[] input, int subArrayLength) {
//        int max = Integer.MIN_VALUE;
//        int inputLength = input.length;
//        for (int i = 0; i <= inputLength - subArrayLength; i++) {
//            int sum = 0;
//            for (int j = i; j < subArrayLength + i; j++) {
//                sum += input[j];
//            }
//            max = Math.max(max, sum);
//        }
//        return max;
//    }
//}

//Time O(m x n)
//Space O(1)


    //TWO POINTER
//    input [1,10,-5,4,7]
//    subArrayLength 3
//    output 9
    public int maxSubarray(Integer[] input, int subArrayLength) {
        int max = Integer.MIN_VALUE;
        int inputLength = input.length;
        int left = 0;
        int right = 0;


        while (right < inputLength) {


            right++;
        }
        return max;
    }
}

//Time O(m x n)
//Space O(1)