package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 17 Medium
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class LetterCombinationsofaPhoneNumber {
	
	//3 ms, faster than 39.26% of Java online submissions for Letter Combinations of a Phone Number.
	char[][] alpnum = new char[][] { { ' ' }, { '*' }, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
		{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
		{ 'w', 'x', 'y', 'z' } };
	List<String> result;
	StringBuilder sb;
	public List<String> letterCombinations(String digits) {
		if(digits.length()==0) {
			return new ArrayList<>();
		}
		result = new ArrayList<>();
		sb = new StringBuilder();
		backtrack(digits,0);
		return result;
	}
	public void backtrack(String digits,int level) {
		if(level>=digits.length()) {
			result.add(sb.toString());
			
		}else {
			//System.out.println(digits.charAt(level)-'0');
			char[] c = alpnum[digits.charAt(level)-'0'];
			for(int i=0;i<c.length;i++) {
				sb.append(c[i]);
				backtrack(digits,level+1);
				sb.delete(sb.length()-1,sb.length());
			}
		}
	}

	
	public void test() {
		List<String> a = letterCombinations("");
		for(String b:a) {
			System.out.println(b);
		}
	}
}
