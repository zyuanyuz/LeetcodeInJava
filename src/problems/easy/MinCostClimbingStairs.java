package problems.easy;

/**
 * @author zyuanyuz
 * @since 2020/12/21 11:19
 */

/**
 * leetcode 746
 */

public class MinCostClimbingStairs {
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.68%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 78.93%
     * 的用户
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] minCostReach = new int[cost.length + 1];
        minCostReach[0] = 0;
        minCostReach[1] = 0;
        for (int i = 2; i < minCostReach.length; i++) {
            minCostReach[i] = Math.min(minCostReach[i - 1] + cost[i - 1], minCostReach[i - 2] + cost[i - 2]);
        }
        return minCostReach[cost.length];
    }

}
