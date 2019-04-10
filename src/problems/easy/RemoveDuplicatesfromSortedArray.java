package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 26 easy
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means modification
 * to the input array will be known to the caller as well.
 * 
 */
public class RemoveDuplicatesfromSortedArray {
	//12 ms, faster than 39.77% of Java online submissions for Remove Duplicates from Sorted Array
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 1; // 如果nums不为0，count最小为1
		int i = 0, j = i + 1;
		while (true) {
			while (j < nums.length && nums[j] == nums[i]) {
				j++;
			}
			if (j >= nums.length) {
				break;
			}
			nums[++i] = nums[j++]; // i++;nums[i]=nums[j];j++;
			count++;
		}

		return count;
	}

	public void test() {
		//
		int[] nums = new int[] { 0, 1, 1, 1, 1, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7 };
		System.out.println(removeDuplicates(nums));
	}
}
