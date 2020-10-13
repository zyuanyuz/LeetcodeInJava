package problems.medium;

/**
 * leetcode 416
 */
public class PartitionEqualSubsetSum {
    /**
     * 执行用时：
     * 44 ms
     * , 在所有 Java 提交中击败了
     * 27.41%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 63.28%
     * 的用户
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxNum) maxNum = num;
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;
        dp[1][0] = true;
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            int one = i % 2, two = i % 2 == 0 ? 1 : 0;
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i]) {
                    dp[one][j] = dp[two][j] | dp[two][j - nums[i]];
                } else {
                    dp[one][j] = dp[two][j];
                }
            }
        }
        return dp[nums.length % 2][target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{1, 4, 5, 6, 1, 2, 4, 1, 3, 4, 1, 2, 4, 5, 1, 91, 4, 5, 6, 1, 2, 4,
                1, 3, 4, 1, 2, 4, 5, 1}));
    }
}