package problems.medium;

// leetcode 209
public class MinimumSizeSubarraySum {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.88% 的用户 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 6.67%
     * 的用户s
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = nums[0];
        while (true) {
            if (sum < s && end < nums.length - 1) {
                end += 1;
                sum += nums[end];
            } else if (sum < s) {
                break;
            } else {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                }
                sum -= nums[start];
                start += 1;
                if (start == nums.length) {
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}