package problems.medium;

import java.util.*;

/**
 * leetcode 137 SingleNumberII Medium
 * 
 * Note:Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */
public class SingleNumberII {
    //Runtime: 6 ms, faster than 10.79% of Java online submissions for Single Number II.
    //Memory Usage: 35.4 MB, less than 93.78% of Java online submissions for Single Number II.
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.keySet().contains(nums[i])) {
                numMap.put(nums[i], 1);
            } else {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            }
        }
        int result = 0;
        Iterator<Integer> iterator = numMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if(numMap.get(num)==1){
                result = num;
                break;
            }
        }
        return result;
    }
}