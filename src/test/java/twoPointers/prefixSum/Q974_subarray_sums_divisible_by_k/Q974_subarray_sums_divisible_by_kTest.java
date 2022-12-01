package twoPointers.prefixSum.Q974_subarray_sums_divisible_by_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q974_subarray_sums_divisible_by_kTest {

    @Test
    void test1() {
        Q974_subarray_sums_divisible_by_k solution = new Q974_subarray_sums_divisible_by_k();
        int[] nums = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = solution.subarraysDivByK(nums, k);
        assertEquals(7, result);
    }

    @Test
    void test2() {
        Q974_subarray_sums_divisible_by_k solution = new Q974_subarray_sums_divisible_by_k();
        int[] nums = new int[]{5};
        int k = 9;
        int result = solution.subarraysDivByK(nums, k);
        assertEquals(0, result);
    }
}