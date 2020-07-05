package problems.medium;

//leetcode 152 MaximumProductSubarray
public class MaximumProductSubarray {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 89.65% 的用户 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 6.67%
     * 的用户
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int imax = nums[0] > 0 ? nums[0] : 0;
        int imin = nums[0] < 0 ? nums[0] : 0;
        int max = Integer.max(imax, Integer.MIN_VALUE);
        int tmp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                imax = Integer.max(nums[i], nums[i] * imax);
                imin = Integer.min(nums[i], nums[i] * imin);
            } else {
                tmp = imax;
                imax = Integer.max(nums[i], nums[i] * imin);
                imin = Integer.min(nums[i], nums[i] * tmp);
            }
            max = Integer.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums = new int[] { 2, -1, 1, 1 };
        System.out.println(m.maxProduct(nums));
    }
}