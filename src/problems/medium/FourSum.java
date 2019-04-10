package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18 Medium
 * 
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 *
 */

public class FourSum {
	//88 ms, faster than 18.35% of Java online submissions for 4Sum.
	public List<List<Integer>> fourSumone(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int inowtarget = target;
		int jnowtarget = target;   //分层次的求和目标不同
		for (int i = 0; i < nums.length - 3; i++) { // 选第一个数
			while (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
				i++;
			}
			inowtarget = target - nums[i];
			for (int j = i + 1; j < nums.length - 2; j++) {
				while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) { // 注意测试上边界num.length-2
					j++;
				}
				jnowtarget = inowtarget - nums[j];
				//System.out.println(nowtarget);
				int x = j + 1;
				int y = nums.length - 1;
				while (x < y) {
					int sum = nums[x] + nums[y];
					//System.out.println("sum:"+sum+" target:"+jnowtarget);
					if (sum == jnowtarget) {
						List<Integer> oneresult = new ArrayList<>();
						oneresult.add(nums[i]);
						oneresult.add(nums[j]);
						oneresult.add(nums[x]);
						oneresult.add(nums[y]);
						//System.out.println(nums[i]+" "+nums[j]+" "+nums[x]+" "+nums[y]);
						result.add(oneresult);
						x++;
						while (x < nums.length && nums[x] == nums[x - 1])
							x++;
						y--;
						while (y > j && nums[y] == nums[y + 1]) // 这里y>j是否正确？
							y--;
					} else if (sum < jnowtarget) {
						x++;
						while (x < nums.length && nums[x] == nums[x - 1])
							x++;
					} else {
						y--;
						while (y > j && nums[y] == nums[y + 1])
							y--;
					}
				}
			}
		}

		return result;
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		return null;
	}
	
	
	public void test() {
		List<List<Integer>> result = fourSum(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 }, 0);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
