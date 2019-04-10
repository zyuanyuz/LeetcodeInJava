package problems.easy;

/**
 * leetcode 7
 * 
 * Easy Given a 32-bit signed integer, reverse digits of an integer.
 * 
 */
/* 优化思路- */
//Runtime: 35 ms, faster than 23.39% of Java online submissions for Reverse Integer.
public class ReverseInteger {
	public int reverse(int x) {
		int[] digits = new int[11]; // 32-it the value is between -2147483648 and 2147483647
		int i = 0, j = 0, symbol = 0;
		if (x < 0) {
			symbol = 1;
			x = Math.abs(x);
		}

		while (x / 10 != 0) {
			digits[i] = x % 10;
			x = x / 10;
			i++;
		}
		digits[i] = x % 10;
		long result = 0;
		boolean judgezero = true;
		for (i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 0 && judgezero) {
				continue;
			} else {
				judgezero = false;
				result += digits[i] * (Math.pow(10, j));
				j++;
			}
		}

		// fix the symbol
		if (symbol == 1) {
			result = 0 - result;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}

	public void testCase() {
		int test1 = reverse(2147483647);
		System.out.println(test1);
	}
}
