package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 46 Medium
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 */
public class Permutations {
	//3 ms, faster than 63.48% of Java online submissions for Permutations.
	List<List<Integer>> result;

	public List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
		if (nums.length == 0) {
			List<Integer> nowlist = new ArrayList<>();
			result.add(nowlist);
			return result;
		}
		List<Integer> nowList = new ArrayList<>();
		for (int num : nums) {
			nowList.add(num);
		}
		backtrack(nowList, 0);
		// System.out.println(result);
		return result;
	}

	public void backtrack(List<Integer> list, int n) {
		if (n == list.size()) {
			List nowlist = new ArrayList<>();
			for (Integer num : list) {
				nowlist.add(num);
			}
			result.add(nowlist);
		} else {
			for (int i = n; i < list.size(); i++) {
				int tmp = list.get(i); // exchange nums[n] and nums[i]
				list.set(i, list.get(n));
				list.set(n, tmp);
				backtrack(list, n + 1); // next step
				tmp = list.get(i); // exchange nums[n] and nums[i]
				list.set(i, list.get(n));
				list.set(n, tmp);
			}
		}
	}

	public void test() {
		int[] nums = new int[] {1,2,3,4};
		List<List<Integer>> result = permute(nums);
		System.out.println(result);
	}
}
