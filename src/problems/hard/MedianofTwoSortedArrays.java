package problems.hard;

/**
 * leetcode 4 Hard
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Tips:O(log(m+n)),look CLRS3rd 9.3-8
 */

public class MedianofTwoSortedArrays {
	//
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		return 0;
	}

	public void test() {
		int[] nums1 = { 1, 3, 4 };
		int[] nums2 = { 2, 7 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
