package twoPointers.slidingWindow.Q1_two_sum;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q1_two_sumTest {

    /*
    Test case#1
        input nums = [2,7,11,15], target = 9
        output [0,1]
    Test case#2
        input nums = [3,2,4], target = 6
        output [1,2]
    Test case#2
        input nums = nums = [3,3], target = 6
        output [0,1]
*/
    @Test
    void test1() {
        Q1_two_sum solution = new Q1_two_sum();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        assertThat(result, Matchers.anyOf(is(new int[]{0, 1}), is(new int[]{1, 0})));
    }

    @Test
    void test2() {
        Q1_two_sum solution = new Q1_two_sum();
        int[] nums = new int[]{3, 2, 4};
        int[] result = solution.twoSum(nums, 6);
        assertThat(result, Matchers.anyOf(is(new int[]{1, 2}), is(new int[]{2, 1})));
    }

    @Test
    void test3() {
        Q1_two_sum solution = new Q1_two_sum();
        int[] nums = new int[]{3, 3};
        int[] result = solution.twoSum(nums, 6);
        assertThat(result, Matchers.anyOf(is(new int[]{0, 1}), is(new int[]{1, 0})));
    }

    @Test
    void testNegative() {
        Q1_two_sum solution = new Q1_two_sum();
        int[] nums = new int[]{1, -5, 2, -4};
        int[] result = solution.twoSum(nums, -9);
        assertThat(result, Matchers.anyOf(is(new int[]{1, 3}), is(new int[]{3, 1})));
    }
}