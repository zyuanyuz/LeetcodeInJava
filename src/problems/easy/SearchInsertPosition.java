package problems.easy;

/**
 * leetcode 35 Easy
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:Input: [1,3,5,6], 5 Output: 2
 * 
 * Example 2:Input: [1,3,5,6], 2 Output: 1
 * 
 * Example 3:Input: [1,3,5,6], 7 Output: 4
 * 
 * Example 4:Input: [1,3,5,6], 0 Output: 0
 * 
 *
 */
public class SearchInsertPosition {
	//2 ms, faster than 100.00% of Java online submissions for Search Insert Position.
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target < nums[0] || nums[0] == target) {
			return 0;
		} else if (target > nums[nums.length - 1]) {
			return nums.length;
		}

		int result = binarysearch(nums, target, 0, nums.length - 1);
		return result;
	}

	public int binarysearch(int[] nums, int target, int i, int j) {
		int mid = (i + j) / 2;
		if (mid > 0 && nums[mid - 1] < target && nums[mid] >= target) {
			return mid;
		}
		if (nums[mid] < target) {
			return binarysearch(nums, target, mid + 1, j);
		} else {
			return binarysearch(nums, target, i, mid);
		}
	}

	public void test() {
		int[] nums = new int[] { 1, 3 };
		int target = 1;
		System.out.println(searchInsert(nums, target));
	}
}
