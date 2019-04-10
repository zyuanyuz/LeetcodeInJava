package problems.medium;

/**
 * leetcode 3: Meduim
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3.
 *
 * Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1.
 * 
 * Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 *
 */
/* 优化思路： */
public class LongestSubstringWithoutRepeatingChars {
	//158 ms, faster than 10.64% of Java online submissions
	public int lengthOfLongestSubstring(String s) {
		StringBuilder sb = new StringBuilder(s);
		int target = 0;	 //记录最好情况的长度
		StringBuilder tmpstr = new StringBuilder();  //记录测试的字符串
		int offset = 0;  //记录偏置，用以加速程序
		
		labelone:
		for(int i = 0;i<s.length();i++) {
			labeltwo:
			for(int j = i;j<s.length();j++) {
				
				char tmp = sb.charAt(j);
				for(int k = 0;k<tmpstr.length();k++) {   //test:这里可不可以换成k<j-i
					if(tmp==tmpstr.charAt(k)) {
						offset = k;
						break labeltwo;
					}
				}
				tmpstr.append(tmp);//通过检测将字符加入
			}
			target = target<tmpstr.length()?tmpstr.length():target;
			System.out.println("offset:"+offset);
			i += offset;
			offset = 0;
			tmpstr.delete( 0, tmpstr.length());  //清空tmpstr,test:不清空会造成什么后果？
			if((sb.length()-i-1)<target){   //如果余下串的长度不及target的话
				break labelone;
			}
		}
		return target;
	}
	public void test() {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
