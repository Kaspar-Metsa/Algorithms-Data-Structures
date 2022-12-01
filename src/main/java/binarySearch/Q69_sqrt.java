package binarySearch;

public class Q69_sqrt {
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }
        if (x == 2 || x == 1) {
            return 1;
        }

        long left = 0;
        long right = x / 2 + 1; //+1 because of 4

        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }
}