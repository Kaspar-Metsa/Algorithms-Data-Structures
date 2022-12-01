package twoPointers.slidingWindow.Q15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q15_3Sum {
    /*
        Test case#1
            input nums = [-1,0,1,2,-1,-4]
            output [[-1,-1,2],[-1,0,1]]
        Test case#2
            input nums = [0,1,1]
            output []
        Test case#3
            input nums = [0,0,0]
            output [[0,0,0]]
    */

    public List<List<Integer>> threeSum(int[] nums) {
//        TreeSet<ArrayList<Integer>> treeSet = new TreeSet<>(new TripletComparator());
        List<List<Integer>> solution = new ArrayList<>();
        int[] copiedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copiedArray);

        for (int outerLeft = 0; outerLeft < copiedArray.length - 1; outerLeft++) {
            if (copiedArray[outerLeft] > 0) {
                break;
            }
            if (outerLeft != 0 && copiedArray[outerLeft] == copiedArray[outerLeft - 1]) {
                continue;
            }
            int right = copiedArray.length - 1;
            int left = outerLeft + 1;
            while (right > left) {
                if (copiedArray[left] + copiedArray[right] == -copiedArray[outerLeft]) {
                    solution.add(new ArrayList<>(Arrays.asList(copiedArray[outerLeft], copiedArray[left], copiedArray[right])));
                    left++;
                    while (left < right && copiedArray[left] == copiedArray[left - 1]) {
                        left++;
                    }
                } else if (copiedArray[left] + copiedArray[right] > -copiedArray[outerLeft]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return solution;
//        return new ArrayList<>(treeSet);
    }


    class TripletComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if (o1.get(0).equals(o2.get(0)) && o1.get(1).equals(o2.get(1)) && o1.get(2).equals(o2.get(2))) {
                return 0;
            } else if (o1.get(0) < o2.get(0)) {
                return -1;
            } else if (o1.get(0).equals(o2.get(0)) && o1.get(1) < o2.get(1)) {
                return -1;
            } else if (o1.get(0).equals(o2.get(0)) && o1.get(1).equals(o2.get(1)) && o1.get(3) < o2.get(3)) {
                return -1;
            } else if (o2.get(0) < o1.get(0)) {
                return 1;
            } else if (o1.get(1) > o2.get(1)) {
                return 1;
            } else {
                return 1;
            }
        }
    }


//    Brute Force
//    public List<List<Integer>> threeSum(int[] nums) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.get(nums[i]).add(i);
//            } else {
//                map.put(nums[i], new ArrayList<>(List.of(i)));
//            }
//        }
//        List<List<Integer>> valuesResults = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (map.containsKey(0 - nums[i] - nums[j])) {
//                    for (Integer index : map.get(0 - nums[i] - nums[j])) {
//                        if (index == i || index == j) {
//                            continue;
//                        }
//                        List<Integer> currentValueResult = new ArrayList<>(Arrays.asList(nums[index], nums[i], nums[j]));
//                        Collections.sort(currentValueResult);
//                        if (!valuesResults.contains(currentValueResult)) {
//                            valuesResults.add(currentValueResult);
//                        }
//                    }
//                }
//            }
//        }
//        return valuesResults;
//    }
}


