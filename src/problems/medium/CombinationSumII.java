package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 40 Medium
 * 
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 *
 */
public class CombinationSumII {
	//23 ms, faster than 22.35% of Java online submissions for Combination Sum II.
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> nowList = new ArrayList<>();
	int nowSum = 0;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		backtrack(candidates, target, 0, 0);
		return result;
	}

	public int backtrack(int[] candidates, int target, int n, int lastnum) {
		if (nowSum == target) {
			label: for (List<Integer> oneresult : result) { // 检查重复，这里需要优化
				if (oneresult.size() != nowList.size()) {
					continue;
				}
				// boolean isExist = false;
				for (int i = 0; i < nowList.size(); i++) {
					if (nowList.get(i) != oneresult.get(i)) {
						continue label;
					}
					if (i == nowList.size() - 1) {
						return 1; // 已存在，不添加的情况
					}
				}
			}
			List<Integer> list = new ArrayList<>();
			for (int num : nowList) {
				list.add(num);
			}
			result.add(list);
		} else if (n < candidates.length) {
			if (nowSum + candidates[n] <= target && candidates[n] >= lastnum) { // 选择candidates[n]，加入列表
				nowSum += candidates[n];
				nowList.add(candidates[n]);
				System.out.println("one" + nowList);
				backtrack(candidates, target, n + 1, candidates[n]);
				nowSum -= candidates[n];
				nowList.remove(nowList.size() - 1);
				// System.out.println(nowList);
			}
			System.out.println("two" + nowList);
			backtrack(candidates, target, n + 1, lastnum); // candidates[n]不加入列表
		}
		return 1;
	}

	public void test() {
		int[] candidates = new int[] { 1, 2, 1, 1 }; // 包含重复项
		int target = 8;
		System.out.println(combinationSum2(candidates, target));
	}
}
