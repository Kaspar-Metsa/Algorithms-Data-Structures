package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q509_Fibonacci_NumberTest {

//    @Test
//    void test1() {
//        Q509_Fibonacci_Number solution = new Q509_Fibonacci_Number();
//        int result = solution.fib(2);
//        assertEquals(1, result);
//    }
//
//    @Test
//    void test2() {
//        Q509_Fibonacci_Number solution = new Q509_Fibonacci_Number();
//        int result = solution.fib(3);
//        assertEquals(2, result);
//    }


    @Test
    void test3() {
        Q509_Fibonacci_Number solution = new Q509_Fibonacci_Number();
        int result = solution.fib(30);
        assertEquals(832040, result);
    }
}