package problems.easy;

/**
 * leetcode 14 easy
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl"
 * 
 * Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings.
 */

public class LongestCommonPrefix {
	//9 ms, faster than 68.52% of Java online submissions for Longest Common Prefix.
	public String longestCommonPrefix(String[] strs) {
		int prelength = 0;
		if(strs.length==0) {
			return "";
		}
		label: for (int i = 0; i < strs[0].length(); i++) {
			char nowchar = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i) { // 选择跳出判断的条件
					break label;
				}
				if (strs[j].charAt(i) != nowchar) {
					break label;
				}
			}
			prelength++;
		}
		String result = strs[0].substring(0, prelength);
		return result;
	}

	public void test() {
		// "flower","flow","flight"
		// "","",""
		// "dog","racecar","car"
		// empty case : []
		String[] strings = new String[] { };
		System.out.println(longestCommonPrefix(strings));
	}
}
