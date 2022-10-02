package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.List;

public class CountOfDistinctElementsInEverySubarray {
    /*
    Find the count of distinct elements in every subarray of size `k`
    - input : arr = {10, 12, 32, 10, 12, 233, 10, 31, 104, 100}, k = 5
    - output : {3, 4, 4 , 4, 5, 5}
    - ex. the first 5 elements have 3 distinct elements(10,12,32)…
    */
//    List<Integer> distinctElementsInEveryWindow(List<Integer> input, int windowSize) {
//        List<Integer> result = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < windowSize; i++) {
//            set.add(input.get(i));
//        }
//        result.add(set.size());
//        int left = 0;
//        int right = left + windowSize - 1;
//        while (right < input.size() - 1) {
//            left++;
//            right++;
//            Set<Integer> innerSet = new HashSet<>();
//            for (int j = left; j < left + windowSize; j++) {
//                innerSet.add(input.get(j));
//            }
//            result.add(innerSet.size());
//
//        }
//        return result;
//    }


    //Array of frequencies
    //1,3,5,3,1,2
    //0,1,2,3,4,5
    //frequency array is [0,2,1,2,0,1]
    //Time O(n)
    //Space O(max value of input), we can use map to reduce this size. THINK ABOUT THIS
    List<Integer> distinctElementsInEveryWindow(List<Integer> input, int windowSize) {
        List<Integer> result = new ArrayList<>();
        int[] frequencyArray = new int[100000];
        int counter = 0;
        for (int i = 0; i < windowSize; i++) {
            if (frequencyArray[input.get(i)] == 0) {
                counter++;
            }
            frequencyArray[input.get(i)]++;

        }
        result.add(counter);
        int left = 0;
        int right = left + windowSize - 1;

        while (right < input.size() - 1) {

            if (frequencyArray[input.get(left)] == 1) {
                counter--;
            }
            frequencyArray[input.get(left)]--;

            left++;
            right++;
            if (frequencyArray[input.get(right)] == 0) {
                counter++;
            }
            frequencyArray[input.get(right)]++;
            result.add(counter);
        }
        return result;
    }

}