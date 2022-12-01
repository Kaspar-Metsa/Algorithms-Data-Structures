package twoPointers.slidingWindow.Q713_subarray_product_less_than_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q713_subarray_product_less_than_kTest {
    /*
        Test case#1
            input nums = [10,5,2,6], k = 100
            output 8
        Test case#2
            input nums = [1,2,3], k = 0
            output 0
        Test case#3
            input whatever k=0 or k=1
            output 0, because min(nums[whatever])==1
    */
    @Test
    void test1() {
        Q713_subarray_product_less_than_k solution = new Q713_subarray_product_less_than_k();
        int[] nums = new int[]{10, 5, 2, 6};
        int result = solution.numSubarrayProductLessThanK(nums, 100);
        assertEquals(8, result);
    }

    @Test
    void test2() {
        Q713_subarray_product_less_than_k solution = new Q713_subarray_product_less_than_k();
        int[] nums = new int[]{1, 2, 3};
        int result = solution.numSubarrayProductLessThanK(nums, 0);
        assertEquals(0, result);
    }
}