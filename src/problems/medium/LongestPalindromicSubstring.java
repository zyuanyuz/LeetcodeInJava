package problems.medium;

/**
 * leetcode 5 LongestPalindromicSubstring Medium
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Dynamic Programming & Manacher's Algorithm
 */

public class LongestPalindromicSubstring {
	// Runtime: 65 ms, faster than 27.42% of Java online submissions for Longest Palindromic Substring.
 	//Memory Usage: 39.4 MB, less than 19.86% of Java online submissions for Longest Palindromic Substring.
	// Dynamic Programming
	public String longestPalindrome(String s) {
		if (s.length() == 0)
			return s;
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int start = 0, end = 1;
		for (int length = 1; length <= s.length(); length++) {
			for (int i = 0; i < s.length() - length + 1; i++) {
				if (length == 1)
					isPalindrome[i][i + length - 1] = true;
				else if (length == 2)
					isPalindrome[i][i + length - 1] = (s.charAt(i) == s.charAt(i + length - 1));
				else if (s.charAt(i) == s.charAt(i + length - 1))
					isPalindrome[i][i + length - 1] = isPalindrome[i + 1][i + length - 2];
				if (isPalindrome[i][i + length - 1] && length > end - start)
					end = (start = i) + length;
			}
		}
		return s.substring(start, end);
	}

	//
	// Manacher's Algorithm
	public String longestPalindrome1(String s) {

		return null;
	}

	public void test() {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
}
