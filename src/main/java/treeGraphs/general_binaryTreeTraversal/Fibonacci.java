package treeGraphs.general_binaryTreeTraversal;

public class Fibonacci {
    /*
        Time:  O(2^n)
        Space O(1) why??
    */
    int findFibonacci_naive(int n) {
        if (n == 0 || n == 1) return n;
        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

    /*
        Time:  O(n)
        Space:  O(1)
    */
    int findFibonacci(int n) {
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

}
