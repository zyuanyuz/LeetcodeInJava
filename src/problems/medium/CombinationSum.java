package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 39 Medium
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3]]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8, A solution set is: [ [2,2,2,2],
 * [2,3,3], [3,5] ]
 */

public class CombinationSum {
	//10 ms, faster than 59.77% of Java online submissions for Combination Sum.
	int countnow = 0;
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> nowList = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0) {
			return result;
		}
		function(candidates, target, 0);
		return result;
	}

	public void function(int[] candidates, int target, int lastnum) { // 大于等于上一次的数字才能添加,可以避免重复
		if (countnow == target) {
			//System.out.println("ok");
			List<Integer> nowListOne = new ArrayList<>();
			for(int num:nowList) {
				nowListOne.add(num);
			}
			result.add(nowListOne);
			//System.out.println(result);
		} else if (countnow < target) {

			for (int i = 0; i < candidates.length; i++) {
				if (countnow + candidates[i] > target || candidates[i] < lastnum) {
					continue;
				}
				countnow += candidates[i];
				nowList.add(candidates[i]);
				function(candidates, target, candidates[i]);
				countnow -= candidates[i];
				nowList.remove(nowList.size() - 1);
			}
		}
	}

	public void test() {
		int[] candidates = new int[] { };
		int target = 8;
		List<List<Integer>> nowresult = combinationSum(candidates, target);
		System.out.println(result);
	}
}
