package problems.medium;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * leetcode 15 Medium
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 */

public class ThreeSum {
	
	//82 ms, faster than 30.44% of Java online submissions for 3Sum.
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);  //先排序
//		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + " ");
//		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < nums.length; i++) { // 被提取出的数标号

			while (i > 0 && i < nums.length && nums[i - 1] == nums[i])
				i++;
			
			if(i==nums.length)break;
			
			int target = 0 - nums[i];
			int x = i + 1;
			//System.out.println("i" + (x - 1));
			int y = nums.length - 1;

			while (x < y) {
				int sum = nums[x] + nums[y];
				if (sum == target) {
					List<Integer> oneresult = new ArrayList<>();
					oneresult.add(nums[i]);
					oneresult.add(nums[x]);
					oneresult.add(nums[y]);
					Collections.sort(oneresult);
					result.add(oneresult);
					while (x < y && nums[x] == nums[x + 1]) { // 这里也要去除重复值！！
						x++;
					}
					x++;
					while (x < y && nums[y] == nums[y - 1]) {
						y--;
					}
					y--;
				} else if (sum < target) { // 排序的用处
					x++;
				} else {
					y--;
				}
			}
		}

		return result;
	}

	public void test() {
		List<List<Integer>> result = threeSum(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 });
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
