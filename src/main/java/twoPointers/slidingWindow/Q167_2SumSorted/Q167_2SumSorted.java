package twoPointers.slidingWindow.Q167_2SumSorted;

public class Q167_2SumSorted {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */


    //Sliding Window solution
    //Time O(n)
    //Space O(n)
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }


    //Hashmap solution
    //Time O(n)
    //Space O(n)
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                int smallerResult = Math.min(i + 1, map.get(target - nums[i]) + 1);
//                int largerResult = Math.max(i + 1, map.get(target - nums[i]) + 1);
//                return new int[]{smallerResult, largerResult};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }
}