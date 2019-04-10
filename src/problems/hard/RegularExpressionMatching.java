package problems.hard;

/**
 * leetcode 10 Hard
 * 
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'. '.' Matches any single character.
 * '*'Matches zero or more of the preceding element. The matching should cover
 * the entire input string (not partial).
 */

public class RegularExpressionMatching {
	//28 ms, faster than 49.86% of Java online submissions for Regular Expression Matching.
	public boolean isMatch(String s, String p) {
		int[][] c = new int[p.length() + 1][s.length() + 1];
		c[0][0] = 1;
		for (int i = 1; i < s.length() + 1; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i < p.length() + 1; i++) {
			if (p.charAt(i - 1) == '*') {
				c[i][0] = c[i - 2][0]; // 在初始化时是*时，填前面两位的值，相当于下面的不匹配情况
			} else {
				c[i][0] = 0;
			}
		}

		for (int i = 1; i < p.length() + 1; i++) {
			for (int j = 1; j < s.length() + 1; j++) {
				if (p.charAt(i - 1) == s.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1];
				} else if (p.charAt(i - 1) == '.') {
					c[i][j] = c[i - 1][j - 1];
				} else if (p.charAt(i - 1) == '*') { // 对于'*'的处理是整个问题的核心部分
					if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {  //字符匹配的情况
						c[i][j] = ((c[i][j - 1] == 1) || (c[i - 2][j] == 1)) ? 1 : 0;
					} else {
						c[i][j] = c[i - 2][j]; // 因为'*'可以表示0次，不匹配时回退两步
					}
				} else {
					c[i][j] = 0;
				}
			}
		}

//		for (int i = 0; i < p.length() + 1; i++) {
//			for (int j = 0; j < s.length() + 1; j++) {
//				System.out.print(c[i][j] + " ");
//			}
//			System.out.println();
//		}

		return c[p.length()][s.length()] == 1 ? true : false;
	}

	public void test() {
		// String s = "aa", p = "a";
		// String s = "aa", p = "a*";
		// String s = "ab",p = ".*";
		String s = "aab", p = "c*a*b";
		// String s = "mississippi",p = "mis*is*p*.";
		// String s = "asd", p = ".s*d";
		// String s = "casdsd", p = ".a.*d";
		System.out.println(isMatch(s, p));
	}
}
