package problems.easy;

//leetcode 1
//优化思路：
//Runtime: 24 ms, faster than 37.83% of Java online submissions for Two Sum.
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] a = new int[2];
		for(int i = 0 ;i < nums.length-1;i++) {
			for(int j = i+1;j< nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					a[0] = i;
					a[1] = j;
					return a;
				}
			}
		}
		return null;
	}
}
