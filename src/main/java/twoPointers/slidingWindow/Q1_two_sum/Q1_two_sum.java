package twoPointers.slidingWindow.Q1_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Q1_two_sum {
    /*
        Questions: Can I return the answer in any order? yes
        How large can the input array be? 10000
        Can the numbers in array and target be negative? Yes
        Can there exist multiple valid answers? No

        input nums = [2,7,11,15], target = 9
        output [0,1]
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}