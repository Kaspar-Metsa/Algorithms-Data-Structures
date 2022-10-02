package trees.general_binaryTreeTraversal;

import org.junit.jupiter.api.Test;

import trees.general_binaryTreeTraversal.fibonacci.Fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    Fibonacci fibonacci;

    @Test
    void test3_naive() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_naive(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_naive() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_naive(45);
        assertEquals(1134903170, actualAnswer);
    }

    @Test
    void test3_inPlace() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_inPlace(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_inPlace() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_inPlace(45);
        assertEquals(1134903170, actualAnswer);
    }

    @Test
    void test3_DP() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_DP(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_DP() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_DP(45);
        assertEquals(1134903170, actualAnswer);
    }

    @Test
    void test3_DP_Optimized() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_DP_optimized(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_DP_Optimized() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_DP_optimized(45);
        assertEquals(1134903170, actualAnswer);
    }

    @Test
    void test3_matrix() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_matrix(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_matrix() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_matrix(45);
        assertEquals(1134903170, actualAnswer);
    }

    @Test
    void test3_matrix_optimized() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_matrixOptimized(3);
        assertEquals(2, actualAnswer);
    }

    @Test
    void test45_matrix_optimized() {
        fibonacci = new Fibonacci();
        int actualAnswer = this.fibonacci.findFibonacci_matrixOptimized(45);
        assertEquals(1134903170, actualAnswer);
    }
}