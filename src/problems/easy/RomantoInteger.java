package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 11 easy
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I-1 V-5 X-10 L-50 C-100 D-500 M-1000 For example, two is written
 * as II in Roman numeral, just two one's added together. Twelve is written as,
 * XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomantoInteger {
	//80 ms, faster than 26.97% of Java online submissions for Roman to Integer.
	public int romanToInt(String s) {
		int result = 0, index = 0;
		List<Character> romanlist = new ArrayList<>(); // I-1 V-5 X-10 L-50 C-100 D-500 M-1000
		romanlist.add('I'); // 偶数位index为十位数，奇数index为五位数
		romanlist.add('V');
		romanlist.add('X');
		romanlist.add('L');
		romanlist.add('C');
		romanlist.add('D');
		romanlist.add('M');

		while (index < s.length()) {
			// 在能组成两位字符的情况下
			if (index < s.length() - 1 && romanlist.indexOf(s.charAt(index)) % 2 == 0
					&& romanlist.indexOf(s.charAt(index)) < romanlist.indexOf(s.charAt(index + 1))) {
				// int i = romanlist.indexOf(s.charAt(index)); // 获得字符的索引值
				int j = romanlist.indexOf(s.charAt(index + 1));
				if (j % 2 == 0) {
					result += 9 * Math.pow(10, j / 2 - 1);
				} else {
					result += 4 * Math.pow(10, j / 2);
				}
				index += 2;
			} else {
				int j = romanlist.indexOf(s.charAt(index));
				if (j % 2 == 0) {
					result += Math.pow(10, j / 2);
				} else {
					result += 5 * Math.pow(10, j / 2);
				}
				index++;
			}
		}
		return result;
	}

	public void test() {
		// IV
		// IX
		// LVIII
		// MCMXCIV
		System.out.println(romanToInt("MMCCCXLIII"));
	}
}
