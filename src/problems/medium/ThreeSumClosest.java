package problems.medium;

import java.util.Arrays;

/**
 * leetcode 16 Medium
 * 
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

public class ThreeSumClosest {

	// 17 ms, faster than 38.30% of Java online submissions for 3Sum Closest.
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int absnum = Integer.MAX_VALUE;
		int result = 0;
		int x, y;
		for (int i = 0; i < n - 2; i++) { // 最少三数和，这里i的最大值可以取n-2

//			System.out.println("1:" + target + " " + nums[i]);
			while (i > 0 && i < n - 2 && nums[i - 1] == nums[i]) // 去除对于三数和的重复计算
				i++;
//			System.out.println("2:" + target + " " + nums[i]);

			int nowtarget = target - nums[i]; // 每次循环时的当前目标数
			x = i + 1;
			y = n - 1;
			while (x < y) {
				int tmpsum = nums[x] + nums[y];
				if (Math.abs(tmpsum - nowtarget) < absnum) {
					absnum = Math.abs(tmpsum - nowtarget);
					if (absnum == 0) {
//						System.out.println();
//						System.out.println(nowtarget + " " + target + " " + nums[i] + " " + nums[x] + " " + nums[y]);
						return tmpsum + nums[i]; // 如果两者相等
					}
					result = tmpsum + nums[i];

//					x++;
//					while (x < n && nums[x] == nums[x - 1]) 
//						x++;
//					y--;
//					while (y > 0 && nums[y] == nums[y + 1])
//						y--;

				}
				if (tmpsum < nowtarget) {
					x++;
					while (x < n && nums[x] == nums[x - 1]) // 遇到相同的数即跳过
						x++;
				} else {
					y--;
					while (y > 0 && nums[y] == nums[y + 1])
						y--;
				}
			}
		}
		return result;
	}

	public void test() {
		System.out.println(threeSumClosest(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 }, -100));
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}
}
