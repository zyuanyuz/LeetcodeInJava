package problems.medium;

/**
 * leetcode 34 Medium
 * 
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
	//3 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int index = binarysearch(nums, target, 0, nums.length - 1);
		if (index == -1) {
			return new int[] { -1, -1 };
		}
		int i = index, j = index;
		while (i >= 0 && nums[i] == target) {
			i--;
		}
		while (j < nums.length && nums[j] == target) {
			j++;
		}
		
		return new int[] { ++i, --j };
	}

	public int binarysearch(int[] nums, int target, int i, int j) {
		int mid = (i + j) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (i == j) {
			return -1;
		} else if (nums[mid] < target) {
			return binarysearch(nums, target, mid + 1, j);
		} else {
			return binarysearch(nums, target, i, mid);
		}
	}

	public void test() {
		int[] nums = new int[] { 8, 8, 8, 8, 8 };
		int target = 8;
		for (int a : searchRange(nums, target)) {
			System.out.print(a + " ");
		}

	}
}
