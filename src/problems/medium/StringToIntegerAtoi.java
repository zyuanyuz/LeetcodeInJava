package problems.medium;

/**
 * leetcode 8 Medium
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 */
/**/
//
public class StringToIntegerAtoi {
	// 81 ms, faster than 1.21% of Java online submissions for String to Integer
	// (atoi).
	public int myAtoione(String str) {
		int index = 0, digit = 1;
		Double total = 0D;

		if (str.length() == 0) {
			return 0;

		}
		// System.out.println(str.charAt(index));

		while (index < str.length() && str.charAt(index) == ' ') {
			index++;
		}

		if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
			digit = str.charAt(index) == '-' ? -1 : 1;
			index++;
		}

		if (index >= str.length()) {
			return 0;
		}

		while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			int num = str.charAt(index) - '0';
			total = total * 10 + num;

			index++;
		}

		total = total * digit;
		Integer result = total.intValue();
		if (result >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (result <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return result;
	}

	// 30 ms, faster than 32.26% of Java online submissions for String to Integer
	// (atoi).
	// enough!
	public int myAtoi(String str) {
		int index = 0, digit = 1;
		Double total = 0D;

		if (str.length() == 0) {
			return 0;

		}
		// System.out.println(str.charAt(index));

		while (index < str.length() && str.charAt(index) == ' ') {
			index++;
		}

		if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
			digit = str.charAt(index) == '-' ? -1 : 1;
			index++;
		}

		if (index >= str.length()) {
			return 0;
		}

		while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			int num = str.charAt(index) - '0';
			total = total * 10 + num;
			index++;

			// total = total * digit;
			if (total * digit >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (total * digit <= Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}

		return total.intValue() * digit;
	}

	public void test() {
		// "words and 987"
		// "4193 with words"
		// " -42"
		// "-91283472332"
		// "42"
		System.out.println(myAtoi("+1"));
		System.out.println(myAtoi("-000000000000000000000000000000000000000000000000001"));
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-9223372036854775808"));
	}
}
