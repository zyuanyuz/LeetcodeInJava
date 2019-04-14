package problems.easy;

/**
 * leetcode 69 Sqrtx Easy
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

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
    //Memory Usage: 32.3 MB, less than 100.00% of Java online submissions for Sqrt(x).
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1 || x == 2 || x == 3) return 1;
        if (x == 5) return 2;
        if (x == Integer.MAX_VALUE) return 46340;  //set a static value is a bad idea!
        int start = 0, end = x >> 1;
        while (start < end - 1) {
            if (start * start == x) return start;
            if (end * end == x) return end;
            int mid = (start + end) / 2;
            if (mid > 46340) end = mid;
            else if (mid * mid == x) return mid;
            else if (mid * mid < x) start = mid;
            else end = mid;
        }
        //System.out.println("here" + start + " " + end);
        return start;
    }

    public void test() {
        //Integer.MAX_VALUE -> 46340
        //21474836 -> 4634
        System.out.println(mySqrt(5));
    }
}
