package dp;

public class Q509_Fibonacci_Number {
    /*
        Recursive without memoization
    */
//    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }
    /*
        Recursive with memoization
    */
//    public int fib(int n) {
//        int[] memo = new int[n+1];
//        Arrays.fill(memo, -1);
//        return recurseFib(n, memo);
//    }
//
//    private int recurseFib(int n, int[] memo) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        memo[n] = recurseFib(n - 1, memo) + recurseFib(n - 2, memo);
//
//        return memo[n];
//    }

    /*
        iterative bottom up DP
        Doesn't use recursion stack
    */
    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}