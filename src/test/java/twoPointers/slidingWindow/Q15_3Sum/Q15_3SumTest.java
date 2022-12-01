package twoPointers.slidingWindow.Q15_3Sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q15_3SumTest {

    @Test
    void test1() {
        Q15_3Sum solution = new Q15_3Sum();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, 0, 1));
        expected.add(Arrays.asList(-1, -1, 2));
        assertEquals(expected, result);
    }

    @Test
    void test2() {
        Q15_3Sum solution = new Q15_3Sum();
        List<List<Integer>> result = solution.threeSum(new int[]{0, 1, 1});
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, result);
    }

    @Test
    void test3() {
        Q15_3Sum solution = new Q15_3Sum();
        List<List<Integer>> result = solution.threeSum(new int[]{0, 0, 0});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0));
        assertEquals(expected, result);
    }

    @Test
    void test4() {
        Q15_3Sum solution = new Q15_3Sum();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 0});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, 0, 1));
        assertEquals(expected, result);
    }
}