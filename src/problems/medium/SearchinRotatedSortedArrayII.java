package problems.medium;

/**
 * leetcode 81 SearchinRotatedSortedArrayII Medium
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
public class SearchinRotatedSortedArrayII {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
    //Memory Usage: 39.1 MB, less than 18.41% of Java online submissions for Search in Rotated Sorted Array II.
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return customSearch(nums, 0, nums.length - 1, target);
    }

    boolean customSearch(int[] nums, int start, int end, int target) {
        if (start > end) return false;
        if (start == end && nums[start] == target) {
            return true;
        } else if (start == end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target || nums[start] == target || nums[end] == target) return true;
        if (nums[start] > nums[mid]) {
            if (target > nums[mid] && target < nums[start]) {
                return binarySearch(nums, mid + 1, end - 1, target);
            } else {
                return customSearch(nums, start, mid, target);
            }
        } else if (nums[start] < nums[mid]) {
            if (nums[start] < target && nums[mid] > target) {
                return binarySearch(nums, start + 1, mid - 1, target);
            } else {
                return customSearch(nums, mid + 1, end, target);
            }
        } else {  //nums[start]==nums[mid],I can't think out a good way to handle this situation
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
    }

    //normally binarySearch
    boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return false;
        if (start == end && nums[start] == target) {
            return true;
        } else if (start == end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }

    public void test() {
        //2, 5, 6, 0, 0, 1, 2
        int[] nums = new int[]{1, 3, 1, 1, 1};
        System.out.println(search(nums, 3));
    }
}
