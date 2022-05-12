package treeGraphs.general_binaryTreeTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    Fibonacci fibonacci;

    @BeforeEach
    void beforeEach() {
        fibonacci = new Fibonacci();
    }

    @Test
    void test3() {
        int actualAnswer = this.fibonacci.findFibonacci(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test7() {
        int actualAnswer = this.fibonacci.findFibonacci(7);
        assertEquals(13, actualAnswer);
    }


    @Test
    void test15() {
        int actualAnswer = this.fibonacci.findFibonacci(15);
        assertEquals(610, actualAnswer);
    }

    @Test
    void test18() {
        int actualAnswer = this.fibonacci.findFibonacci(18);
        assertEquals(2584, actualAnswer);
    }

    @Test
    void test25() {
        int actualAnswer = this.fibonacci.findFibonacci(25);
        assertEquals(75025, actualAnswer);
    }

    @Test
    void test35() {
        int actualAnswer = this.fibonacci.findFibonacci(35);
        assertEquals(9227465, actualAnswer);
    }

    @Test
    void test45() {
        int actualAnswer = this.fibonacci.findFibonacci(45);
        assertEquals(1134903170, actualAnswer);
    }
}