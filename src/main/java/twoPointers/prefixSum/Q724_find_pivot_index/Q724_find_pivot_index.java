package twoPointers.prefixSum.Q724_find_pivot_index;

public class Q724_find_pivot_index {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public int pivotIndex(int[] nums) {
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
        }

        for (int i = 0; i < sumArray.length; i++) {
            if (i == 0 && sumArray[sumArray.length - 1] - sumArray[i] == 0) {
                return i;
            } else if (i > 0 && sumArray[sumArray.length - 1] - sumArray[i] == sumArray[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}