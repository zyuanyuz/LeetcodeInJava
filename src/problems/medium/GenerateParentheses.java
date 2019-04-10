package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22 Medium
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 */

public class GenerateParentheses {
	/**
	 *	backtracking
	 *	2 ms, faster than 59.97% of Java online submissions for Generate Parentheses.
	 */
	List<String> result = new ArrayList<>();
	StringBuilder sb = new StringBuilder();

	private void backtrack(int level, int leftcount, int rightcount, int n) {
		if (level >= 2 * n) { 
			//System.out.println(sb.toString());
			result.add(sb.toString());
		}
		if (leftcount + 1 <= n) {
			sb.append("(");
			backtrack(level + 1, leftcount + 1, rightcount, n);
			sb.delete(sb.length() - 1, sb.length());
		}
		if (rightcount + 1 <= leftcount) {
			sb.append(")");
			backtrack(level + 1, leftcount, rightcount + 1, n);
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	public List<String> generateParenthesis(int n) {
		
		backtrack(0, 0, 0, n);
		return result;
	}

	public void test() {
		List<String> a = generateParenthesis(0);
		for (String s : a) {
			System.out.print(s + " ");
		}
	}
}
