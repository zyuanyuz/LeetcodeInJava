package problems.easy;

/**
 * leetcode 69 Easy
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class Sqrtx {

    //Time Limit Exceeded for Integer.MAX_VALUE
    public int mySqrt(int x) {

        for (int i = 0; i <= x; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }

    public void test() {
        System.out.println(Integer.MAX_VALUE);
    }
}
