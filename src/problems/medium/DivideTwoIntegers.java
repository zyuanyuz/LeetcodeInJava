package problems.medium;

/**
 * leetcode 29 Medium
 * 
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication(*), division(/) and mod(%) operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2
 * 
 * Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will
 * never be 0. Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For the
 * purpose of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 *
 */

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
		
		return 0;
	}

	public void test() {
		// testcase1:Integer.MAX_VALUE(2147483647), -2000000
		//testcase2:-2147483648, -1
		// int result = divide(Integer.MAX_VALUE, 2);
		int result = divide(-2147483648, -1);
		System.out.println(result);
	}
}
