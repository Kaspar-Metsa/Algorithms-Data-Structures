package binarySearch;

public class Q704_BasicBinarySearch {
    public int search(int[] nums, int target) {
        int left = -1; // Why -1 if minimum value is -10 to 4th power
        int right = nums.length;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (target >= nums[mid]) {
                left = mid;
            }
            if (target < nums[mid]) {
                right = mid;
            }
        }

        if (left != -1 && target == nums[left]) {
            return left; //Because ">=" on line 11
        } else {
            return -1;
        }
    }
}