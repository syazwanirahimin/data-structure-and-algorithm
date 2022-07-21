/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * input: nums = [2,7,11,15], target = 9
 * output: [0,1]
 */

/**
 * Always keep the time/space complexity in mind
 * When you try to optimize a solution, think about the lowest time/space
 * complexity possible
 */

/**
 * 1. Brute Force/ naive solution Time: O(n^2) Space: O(1)
 */

/**
 * 2. Data structure and algorithm: Hash Table - Time: O(n) Space O(n)  care more about time complexity
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution(int[] nums, int target) {
        // intial array as result
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {11,15,2,7};
        int target = 9;
        System.out.println(test.solution(nums, target));

    }


}
