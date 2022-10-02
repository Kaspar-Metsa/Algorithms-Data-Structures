package trees.general_binaryTreeTraversal.fibonacci;
/*
    Fibonacci sequence: 0 1 1 2 3 5 8 13 21 34
    https://leetcode.com/discuss/explore/april-leetcoding-challenge-2021/1159786/fibonacci-number-easy-solution-w-multiple-approaches-explained
*/

public class Fibonacci {
    /*
        Time:  O(2^n) - can be calculated from the recurrence relation T(N) = T(N-1) + T(N-2)
        Space: O(n) - because of call stack
    */
    public int findFibonacci_naive(int n) {
        if (n == 0 || n == 1) return n;
        return findFibonacci_naive(n - 1) + findFibonacci_naive(n - 2);
    }

    /*
        Time:  O(n) because each fibonacci number is only calculated once.
        Space:  O(n) because required for memoization
    */
    public int findFibonacci_DP(int n) {
        // 1 extra to handle case, n = 0
        int memo[] = new int[n + 2];

        int i;

        memo[0] = 0;
        memo[1] = 1;

        for (i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /*
        Time:  O(n) because each fibonacci number is only calculated once.
        Space:  O(1) because required for memoization
    */
    public int findFibonacci_DP_optimized(int n) {
        if (n <= 1)
            return n;
        int prev2 = 0, prev1 = 1, cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }

    /*
    Variation of above approach
        Time:  O(n)
        Space:  O(1)
    */
    public int findFibonacci_inPlace(int n) {
        int num1 = 0, num2 = 1;
        int counter = 0;
        while (counter < n) {
            if (n - 1 == counter) {
                return num2;
            }
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
        return 0;
    }

    /*
        Matrix Exponentiation
        This approach uses a matrix M = [[1, 1], [1, 0]] and based on the observation that pow(M, n) gives us the fibonacci number n at M[0][0].
        Time:  O(N) because we are doing N matrix multiplications.
        Space:  O(1)
    */
    public int findFibonacci_matrix(int n) {
        if (n <= 1) return n;
        int[][] M = new int[][]{{1, 1}, {1, 0}};
        int[][] F = new int[][]{{1, 1}, {1, 0}};
        for (int i = 2; i < n; i++) {
            matrixMultiplication(F, M);
        }
        return F[0][0];
    }

    void matrixMultiplication(int[][] F, int[][] M) {
        int m00 = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int m01 = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int m10 = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int m11 = F[1][0] * M[0][1] + F[1][1] * M[1][1];
        F[0][0] = m00;
        F[0][1] = m01;
        F[1][0] = m10;
        F[1][1] = m11;
    }

    /*
        Matrix Exponentiation Optimized
        This approach uses a matrix M = [[1, 1], [1, 0]] and based on the observation that pow(M, n) gives us the fibonacci number n at M[0][0].
        Time:  O(N) because we are doing N matrix multiplications.
        Space:  O(1)
    */
    public int findFibonacci_matrixOptimized(int n) {
        int[][] F = {{1, 1}, {1, 0}};
        int[][] M = {{1, 1}, {1, 0}};
        if (n <= 1) return n;
        power(F, n - 1, M);
        return F[0][0];
    }

    void power(int[][] F, int n, int[][] M) {
        if (n <= 1) return;
        power(F, n / 2, M);
        matrixMultiplication_optimized(F, F);
        if ((n & 1) != 0) {
            matrixMultiplication_optimized(F, M);
        }
    }

    void matrixMultiplication_optimized(int[][] F, int[][] M) {
        int m00 = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int m01 = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int m10 = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int m11 = F[1][0] * M[0][1] + F[1][1] * M[1][1];
        F[0][0] = m00;
        F[0][1] = m01;
        F[1][0] = m10;
        F[1][1] = m11;
    }

}
