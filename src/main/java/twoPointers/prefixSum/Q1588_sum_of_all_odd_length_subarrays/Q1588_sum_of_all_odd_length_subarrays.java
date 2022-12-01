package twoPointers.prefixSum.Q1588_sum_of_all_odd_length_subarrays;

public class Q1588_sum_of_all_odd_length_subarrays {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public int sumOddLengthSubarrays(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        int[] prefixArray = new int[arr.length + 1];
        prefixArray[0] = 0;
        prefixArray[1] = arr[0];
        for (int i = 1; i < arr.length + 1; i++) {
            prefixArray[i] = prefixArray[i - 1] + arr[i - 1];
        }

        int totalSum = 0;
        for (int winSize = 1; winSize <= arr.length; winSize += 2) {

            for (int i = 0; i < arr.length - winSize + 1; i++) {
                int left = i;
                int right = i + winSize;
                totalSum += prefixArray[right] - prefixArray[left];
            }


        }
        return totalSum;
    }
}