package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q69_sqrtTest {

    @Test
    void test1() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(4);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(8);
        assertEquals(2, result);
    }

    @Test
    void test3() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(9);
        assertEquals(3, result);
    }

    @Test
    void test4() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(10);
        assertEquals(3, result);
    }

    @Test
    void test5() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(100);
        assertEquals(10, result);
    }

    @Test
    void test6() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(1);
        assertEquals(1, result);
    }

    @Test
    void test7() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(0);
        assertEquals(0, result);
    }

    @Test
    void test8() {
        Q69_sqrt solution = new Q69_sqrt();
        int result = solution.mySqrt(2_147_395_599);//2_147_483_647 1_073_697_800 484_528_144
        assertEquals(46339, result);
    }
}