package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 20 easy
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:Input: "()" Output: true
 * 
 * Example 2:Input: "()[]{}" Output: true
 * 
 * Example 3:Input: "(]" Output: false
 * 
 * Example 4:Input: "([)]" Output: false
 * 
 * Example 5:Input: "{[]}" Output: true
 *
 */
public class ValidParentheses {
	//15 ms, faster than 4.08% of Java online submissions for Valid Parentheses.
	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		List<Character> leftsign = new ArrayList<>();
		leftsign.add('(');
		leftsign.add('{');
		leftsign.add('[');
		List<Character> rightsign = new ArrayList<>();
		rightsign.add(')');
		rightsign.add('}');
		rightsign.add(']');
		Stack<Integer> leftstack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (leftsign.contains(s.charAt(i))) {
				leftstack.add(leftsign.indexOf(s.charAt(i)));
				continue;
			} else {
				if (!leftstack.isEmpty() && rightsign.indexOf(s.charAt(i)) == leftstack.pop()) {
					continue;
				} else {
					return false;
				}
			}
		}

		if (leftstack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void test() {
		String s = "]";
		System.out.println(isValid(s));
	}
}
