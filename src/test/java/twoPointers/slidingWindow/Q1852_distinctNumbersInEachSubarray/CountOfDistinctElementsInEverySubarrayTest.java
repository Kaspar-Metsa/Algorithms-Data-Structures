package twoPointers.slidingWindow.Q1852_distinctNumbersInEachSubarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountOfDistinctElementsInEverySubarrayTest {

    @Test
    void test1() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        int[] input = new int[]{1, 2, 1, 3, 4, 2, 3};
        int[] result = countOfDistinctElementsInEverySubarray.distinctNumbers(input, 4);
        assertArrayEquals(new int[]{3, 4, 4, 3}, result);
    }

    @Test
    void test2() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        int[] input = new int[]{1, 2, 4, 4};
        int[] result = countOfDistinctElementsInEverySubarray.distinctNumbers(input, 2);
        List<Integer> answer = Arrays.asList(2, 2, 1);
        assertArrayEquals(new int[]{2, 2, 1}, result);
    }

    @Test
    void test3() {
        CountOfDistinctElementsInEverySubarray countOfDistinctElementsInEverySubarray = new CountOfDistinctElementsInEverySubarray();
        int[] input = new int[]{10, 12, 32, 10, 12, 233, 10, 31, 104, 100};
        int[] result = countOfDistinctElementsInEverySubarray.distinctNumbers(input, 5);
        assertArrayEquals(new int[]{3, 4, 4, 4, 5, 5}, result);
    }
}