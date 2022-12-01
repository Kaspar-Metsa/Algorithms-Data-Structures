package twoPointers.slidingWindow.Q977_squares_of_a_sorted_array;

public class Q977_squares_of_a_sorted_array {
    /*
        Questions
            Can the input array contain negative elements? Yes
            How large can the input array be? 10 000
            How large can the numbers in the array be? From -10 000 to 10 000

        input nums = [-4,-1,0,3,10]
        output [0,1,9,16,100]
    */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int i = 1;

        while (nums.length - i >= 0) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare >= rightSquare) {
                result[nums.length - i] = leftSquare;
                left++;
            } else {
                result[nums.length - i] = rightSquare;
                right--;
            }
            i++;
        }
        return result;
    }
}