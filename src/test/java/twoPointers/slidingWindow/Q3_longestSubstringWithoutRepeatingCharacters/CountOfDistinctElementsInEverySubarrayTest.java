package twoPointers.slidingWindow.Q3_longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOfDistinctElementsInEverySubarrayTest {

    @Test
    void test1() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        List<Integer> input = Arrays.asList(1, 2, 1, 3, 4, 2, 3);
        List<Integer> result = countOfDistinctElementsInEverySubarray.distinctElementsInEveryWindow(input, 4);
        List<Integer> answer = Arrays.asList(3, 4, 4, 3);
        assertEquals(answer, result);
    }

    @Test
    void test2() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        List<Integer> input = Arrays.asList(1, 2, 4, 4);
        List<Integer> result = countOfDistinctElementsInEverySubarray.distinctElementsInEveryWindow(input, 2);
        List<Integer> answer = Arrays.asList(2, 2, 1);
        assertEquals(answer, result);
    }

    @Test
    void test3() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        List<Integer> input = Arrays.asList(10, 12, 32, 10, 12, 233, 10, 31, 104, 100);
        List<Integer> result = countOfDistinctElementsInEverySubarray.distinctElementsInEveryWindow(input, 5);
        List<Integer> answer = Arrays.asList(3, 4, 4, 4, 5, 5);
        assertEquals(answer, result);
    }
}