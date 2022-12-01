package twoPointers.prefixSum.Q974_subarray_sums_divisible_by_k;


public class Q974_subarray_sums_divisible_by_k {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
//Time On2
//    public int subarraysDivByK(int[] nums, int k) {
//        int[] prefixArray = new int[nums.length + 1];
//        prefixArray[0] = 0;
//        prefixArray[1] = nums[0];
//        for (int i = 1; i < nums.length + 1; i++) {
//            prefixArray[i] = prefixArray[i - 1] + nums[i - 1];
//        }
//
//        int countSuccessfulDivisions = 0;
//        for (int i = prefixArray.length - 1; i >= 1; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                if ((prefixArray[i] - prefixArray[j]) % k == 0) {
//                    countSuccessfulDivisions++;
//                }
//            }
//        }
//        return countSuccessfulDivisions;
//    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] fq = new int[k]; // "moduloK : Times I've seen it so far"
        fq[0] = 1; //Explained:
        int sum = 0; // This is the accumulative sum of the elements of A
        int count = 0; // The count of wanted subarrays, whose Sum % K == 0
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k; //ALWAYS CHOOSE THE POSITIVE REMAINDER
            }
            count += fq[remainder];
            fq[remainder]++;
        }
        return count;
    }
}
