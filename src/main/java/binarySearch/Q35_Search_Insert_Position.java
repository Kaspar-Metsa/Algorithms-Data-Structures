package binarySearch;

public class Q35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {

        int left = -1;
        int right = nums.length;

        while (left + 1 < right) {
            int middle = (left + right) / 2;

            if (target > nums[middle]) {
                left = middle;
            }
            if (target <= nums[middle]) {
                right = middle;
            }
        }
        return right;
    }
}