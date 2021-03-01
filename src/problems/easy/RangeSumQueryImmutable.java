package problems.easy;

/**
 * leetcode 303
 */
public class RangeSumQueryImmutable {
    /**
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 77.14%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 13.85%
     * 的用户
     */
    public static
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for (int i = 1; i < nums.length + 1; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }
}
