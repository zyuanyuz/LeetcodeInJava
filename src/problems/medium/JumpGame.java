package problems.medium;

/**
 * leetcode 55 Medium
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    //Runtime: 246 ms, faster than 19.66% of Java online submissions for Jump Game.
    //Memory Usage: 41 MB, less than 31.26% of Java online submissions for Jump Game.
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i > nums.length - 1) {
                nums[i] = nums.length - 1;
            }
            int jumpMost = i;
            for (int j = 1; j <= nums[i]; j++) {
                int index = i + j > nums.length - 1 ? nums.length - 1 : i + j;
                jumpMost = jumpMost < nums[index] ? nums[index] : jumpMost;
            }
            nums[i] = jumpMost;
        }
        for(int index:nums){
            System.out.print(index+"\t");
        }
        return nums[0] == nums.length - 1;
    }

    public void test() {
        int[] nums = new int[]{2, 3, 1, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
