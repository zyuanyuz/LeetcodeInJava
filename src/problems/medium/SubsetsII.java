package problems.medium;

import java.util.*;

/**
 * leetcode 90 SubsetsII Medium
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return null;
    }

    public void test() {
        //1, 1, 2, 2, 2, 3, 3
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 3};
        List<List<Integer>> result = subsetsWithDup(nums);
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.println();
            }
        }
    }
}
