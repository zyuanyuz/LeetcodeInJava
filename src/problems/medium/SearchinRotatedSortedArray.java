package problems.medium;

/**
 * leetcode 33 Medium
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */
public class SearchinRotatedSortedArray {
    //Runtime: 5 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
    //Memory Usage: 39.5 MB, less than 25.10% of Java online submissions for Search in Rotated Sorted Array.
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return mybinarysearch(nums, 0, nums.length - 1, target);
    }

    public int mybinarysearch(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (start == end) {
            return -1;
        }
        if(start==end-1){
            if(nums[start]==target)return start;
            else if(nums[end]==target)return end;
            else return -1;
        }

        if (nums[middle] < nums[start] && nums[middle] < nums[end]) {
            if (target >= nums[start] || target < nums[middle]) {
                return mybinarysearch(nums, start, middle - 1, target);
            } else {
                return mybinarysearch(nums, middle + 1, end, target);
            }
        } else if (nums[middle] > nums[start] && nums[middle] > nums[end]) {
            if (target <= nums[end] || target > nums[middle]) {
                return mybinarysearch(nums, middle + 1, end, target);
            } else {
                return mybinarysearch(nums, start, middle - 1, target);
            }
        } else {//use binarysearch like normal sorted array
            if (nums[middle] < target) {
                return mybinarysearch(nums, middle + 1, end, target);
            } else{
                return mybinarysearch(nums, start, middle - 1, target);
            }
        }
    }

    public void test() {
        //7, 0, 1, 2, 4, 5, 6
        //4, 5, 6, 7, 0, 1, 2
        //1,3 target:0
        //3,1 target:1
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 1));
    }
}
