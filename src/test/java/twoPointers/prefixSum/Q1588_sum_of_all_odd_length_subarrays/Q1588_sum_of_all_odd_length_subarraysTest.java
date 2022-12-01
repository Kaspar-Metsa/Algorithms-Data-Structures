package twoPointers.prefixSum.Q1588_sum_of_all_odd_length_subarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q1588_sum_of_all_odd_length_subarraysTest {

    @Test
    void test1() {
        Q1588_sum_of_all_odd_length_subarrays solution = new Q1588_sum_of_all_odd_length_subarrays();
        int result = solution.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
        assertEquals(58, result);
    }

    @Test
    void test2() {
        Q1588_sum_of_all_odd_length_subarrays solution = new Q1588_sum_of_all_odd_length_subarrays();
        int result = solution.sumOddLengthSubarrays(new int[]{1, 2});
        assertEquals(3, result);
    }

    @Test
    void test3() {
        Q1588_sum_of_all_odd_length_subarrays solution = new Q1588_sum_of_all_odd_length_subarrays();
        int result = solution.sumOddLengthSubarrays(new int[]{10, 11, 12});
        assertEquals(66, result);
    }
}