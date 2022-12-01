package twoPointers.prefixSum.Q1480_running_sum_1d;

public class Q1480_running_sum_1d {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[0] = nums[0];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }
}