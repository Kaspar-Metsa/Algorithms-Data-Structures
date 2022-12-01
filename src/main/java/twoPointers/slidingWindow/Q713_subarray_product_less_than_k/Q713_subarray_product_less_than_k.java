package twoPointers.slidingWindow.Q713_subarray_product_less_than_k;

public class Q713_subarray_product_less_than_k {
    /*
        Questions
            What is the maximum number of elements in nums? 10 000
            What is the minimum value of any element in array? 1
            What is the max value of any element in array? 1000
            What is the min and max k can be? 1<=k<=1 000 000

            input nums = [10,5,2,6], k = 100
            output 8

            nums.length=4
            count=8
            i=3
            tempMax=
            j=

    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = nums[i];
            if (nums[i] >= k) {
                continue;
            } else {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tempMax *= nums[j];
                if (tempMax >= k) {
                    break;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    //OPTIMAL
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        if (k <= 1) return 0;
//        int prod = 1, ans = 0, left = 0;
//        for (int right = 0; right < nums.length; right++) {
//            prod *= nums[right];
//            while (prod >= k) {
//                prod /= nums[left];
//                left++;
//            }
//            ans += right - left + 1;
//        }
//        return ans;
//    }
}