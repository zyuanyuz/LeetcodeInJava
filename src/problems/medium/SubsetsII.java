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
    //Runtime: 3 ms, faster than 21.34% of Java online submissions for Subsets II.
    //Memory Usage: 37.9 MB, less than 61.13% of Java online submissions for Subsets II.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        backtracking(resultMap, new ArrayList<>(), nums, 0);
        //System.out.println(resultMap.values());
        return new ArrayList<List<Integer>>(resultMap.values());
    }

    public void backtracking(Map<String, List<Integer>> resultMap, List<Integer> list, int[] nums, int n) {
        if (n == nums.length) {
            StringBuilder strBuilder = new StringBuilder("");
            for (Integer num : list) {
                strBuilder.append(num);
            }
            if (!resultMap.keySet().contains(strBuilder.toString())) {
                resultMap.put(strBuilder.toString(), new ArrayList<>(list));
            }
        } else {
            list.add(nums[n]);
            backtracking(resultMap, list, nums, n + 1);
            list.remove(list.size() - 1);
            backtracking(resultMap, list, nums, n + 1);
        }
    }

    public void test() {
        //1, 1, 2, 2, 2, 3, 3
        // 4,1,0
        int[] nums = new int[]{4,1,0};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }
}
