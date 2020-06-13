package problems.easy;

public class SingleNumber {
    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.71% 的用户 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了
     * 5.05% 的用户
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}