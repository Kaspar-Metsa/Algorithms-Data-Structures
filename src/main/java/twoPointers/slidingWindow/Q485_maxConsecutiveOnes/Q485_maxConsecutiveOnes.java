package twoPointers.slidingWindow.Q485_maxConsecutiveOnes;

public class Q485_maxConsecutiveOnes {
    /*
        Test case#1
            input 11001111
            output 4
        Test case#2
            input 1111100011
            output 5

            nums=1, 1, 0, 0, 1, 1, 1, 1
            result=2
            oneCount=2
            left=3
            right=5
    */


    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int oneCount = 0;

        if (nums[0] == 1) {
            oneCount++;
            result++;
        }
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            if (oneCount == right - left + 1) {
                result = Math.max(result, right - left + 1);
                right++;
                if (nums[right] == 1) {
                    oneCount++;
                }
            } else {
                if (nums[left] == 1) {
                    oneCount--;
                }
                left++;
                right++;
                if (nums[right] == 1) {
                    oneCount++;
                }
            }
        }
        if (oneCount == right - left + 1) {
            result = Math.max(result, right - left + 1);
        }

        return result;
    }


//    public int findMaxConsecutiveOnes(int[] nums) {
//        int result = 0;
//        int freq = 0;
//        if (nums[0] == 1) {
//            freq++;
//            result = 1;
//        }
//
//        int left = 0;
//        int right = 0;
//
//        while (right < nums.length - 1) {
//            if (freq == right - left + 1) { //If the number of elements that are in subarray is the number of 1s
//                result = Math.max(result, right - left + 1);
//                right++;
//                if (nums[right] == 1) {
//                    freq++;
//                }
//
//            } else {
//                if (nums[left] == 1) {
//                    freq--;
//                }
//                left++;
//                right++;
//                if (nums[right] == 1) {
//                    freq++;
//                }
//            }
//        }
//        if (freq == right - left + 1) {
//            result = Math.max(result, right - left + 1);
//        }
//        return result;
//    }
}