package twoPointers.slidingWindow.Q1852_distinctNumbersInEachSubarray;

import java.util.HashMap;
import java.util.Map;

public class CountOfDistinctElementsInEverySubarray {
    /*
    Find the count of distinct elements in every subarray of size `k`
    - input : arr = {10, 12, 32, 10, 12, 233, 10, 31, 104, 100}, k = 5
    - output : {3, 4, 4 ,4, 5, 5}

        Time O(n)
        Space O(windowSize), We could use map to reduce this size. How?
    */

    //WITH MAP
    //TIME O(n)
    //SPACE O(N) because every input element could be different
    int[] distinctNumbers(int[] input, int windowSize) {
        int[] result = new int[input.length - windowSize + 1];
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < windowSize; i++) {
            if (map.getOrDefault(input[i], 0) == 0) {
                count++;
            }
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        result[0] = count;

        int left = 0;
        int right = windowSize - 1;

        while (right < input.length - 1) {
            if (map.get(input[left]) == 1) {
                count--;
            }
            map.put(input[left], map.get(input[left]) - 1);

            left++;
            right++;

            if (map.getOrDefault(input[right], 0) == 0) {
                count++;
            }
            map.put(input[right], map.getOrDefault(input[right], 0) + 1);
            result[left] = count;
        }
        return result;
    }
}