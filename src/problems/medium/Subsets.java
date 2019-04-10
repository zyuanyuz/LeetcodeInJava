package problems.medium;

import java.util.*;

/**
 * leetcode 78 Subsets Medium
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
    //Memory Usage: 37.9 MB, less than 14.73% of Java online submissions for Subsets.
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> nowList = new ArrayList<>();
        backtracking(nowList, nums, nums.length, 0);
        return result;
    }

    public void backtracking(List<Integer> nowList, int[] nums, int N, int n) {
        if (n == N) {
            List<Integer> list = new ArrayList<>(nowList);
            result.add(list);
        } else {
            nowList.add(nums[n]);
            backtracking(nowList, nums, N, n + 1);
            nowList.remove(nowList.size() - 1);
            backtracking(nowList, nums, N, n + 1);
        }
    }

    public void test() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }
}
