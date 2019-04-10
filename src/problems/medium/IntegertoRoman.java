package problems.medium;

/**
 * leetcode 12 Medium
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
 * and M (1000) to make 400 and 900. Given an integer, convert it to a roman
 * numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 *
 */

public class IntegertoRoman {
	//88 ms, faster than 13.15% of Java online submissions for Integer to Roman.
	public String intToRomanone(int num) {
		StringBuilder sb = new StringBuilder();
		char[] romantenchar = new char[] { 'I', 'X', 'C', 'M' }; //I-1 V-5 X-10 L-50 C-100 D-500 M-1000
		char[] romanfivechar = new char[] { 'V', 'L', 'D' };

		int bit = 3;
		int bitnum = 0;
		while (num > 0) {
			bitnum = (int) ((int) num / Math.pow(10, bit));
			if (bitnum == 9) {
				sb.append(romantenchar[bit]);
				sb.append(romantenchar[bit+1]);
				num -= 9*Math.pow(10, bit);
				bit--;
			} else if (bitnum >= 5) {
				sb.append(romanfivechar[bit]);
				num -= 5 * Math.pow(10, bit);
			} else if (bitnum == 4) {
				sb.append(romantenchar[bit]);
				sb.append(romanfivechar[bit]);
				num -= 4*Math.pow(10, bit);
				bit--;
			} else {
				for (int i = 0; i < bitnum; i++) {
					sb.append(romantenchar[bit]);
				}
				num -= bitnum * Math.pow(10, bit);
				bit--;
			}
		}

		return sb.toString();

	}
	
	public String intToRoman(int num) {
		return null;
	}

	public void test() {
		System.out.println(intToRoman(1));
	}
}
