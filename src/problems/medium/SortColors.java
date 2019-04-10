package problems.medium;

/**
 * leetcode 75 SortColors Medium
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
    //Memory Usage: 34.8 MB, less than 87.18% of Java online submissions for Sort Colors.
    public void sortColors(int[] nums) {
        int[] colors = new int[]{0, 0, 0};   //O(3) space
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }
        int index = 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (colors[index] == 0) index--;
            nums[i] = index;
            colors[index]--;
        }
    }

    public void test() {
        int[] nums = new int[]{1};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
