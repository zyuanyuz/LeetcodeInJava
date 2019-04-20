package problems.medium;

/**
 * leetcode 50 Pow(x,n) Medium
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class Powxn {
    //Time Limit Exceeded
    public double myPow(double x, int n) {

        double result = countResult(x, n);
        if (result > Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
        else if (result < Double.NEGATIVE_INFINITY) return Double.NEGATIVE_INFINITY;
        else return result;
    }

    private double countResult(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        if (n == 1) {
            return x;
        } else if (n == 2) {
            return x * x;
        }
        if (n == -1) {
            return 1 / x;
        } else if (n == -2) {
            return 1 / x * 1 / x;
        }
        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else if (n > 0) {
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
        } else {
            return myPow(x, n / 2) * myPow(x, n / 2) * 1 / x;
        }
    }

    public void test() {
        System.out.println(myPow(2.10000, 3));
    }
}
