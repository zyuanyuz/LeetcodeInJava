package problems.easy;

/**
 * leetcode 70 ClimbingStairs Easy
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    //Runtime: 2 ms, faster than 87.84% of Java online submissions for Climbing Stairs.
    //Memory Usage: 36.3 MB, less than 51.84% of Java online submissions for Climbing Stairs.
    public int climbStairs(int n) {
        int a1 = 1, a2 = 2, result = a1 + a2;
        if (n == 0) return 1;
        if (n == 1) return a1;
        if (n == 2) return a2;
        for (int i = 3; i < n; i++) {
            int tmp = result;
            result += a2;
            a1 = a2;
            a2 = tmp;
            System.out.println(a1 + "\t" + a2 + "\t" + result);
        }
        return result;
    }

    public void test() {
        System.out.println(climbStairs(3));
    }
}
