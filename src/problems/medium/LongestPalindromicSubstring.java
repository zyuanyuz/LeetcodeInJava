package problems.medium;

/**
 * leetcode 5 Medium
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Dynamic Programming
 */
/*优化思路：*/
//Runtime: 100 ms, faster than 23.46% of Java online submissions for Longest Palindromic Substring.
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int len = s.length();  				//用len表示字符串的长度
		int[][] dp=new int[len][len];		//用数组存储自底向上的中间结果
		for(int i=0;i<len;i++) {//将dp矩阵的对角线上全部设为1，即单个字符是回文子串
			dp[i][i] = 1;
		}
		if(len>=2) {
			for(int i=0;i<len-1;i++) {
				if(s.charAt(i)==s.charAt(i+1)) { //检查2位子串是否为回文子串，以1位和2位串为基础
					dp[i][i+1] = 1;
				}
			}
			for(int sublen=3;sublen<=len;sublen++) {  //对于长度循环，可以堆叠至矩阵角
				for(int i=0;i<len-sublen+1;i++) {
					int j = i+sublen-1;
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = dp[i+1][j-1];
					}
					else {
						dp[i][j] = 0;
					}
				}
			}
		}
		
//		for(int i = 0;i<len;i++) {
//			for(int j=0;j<len;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int start=0,end=len-1;
		Label:
		for(int sublen = len;sublen>=1;sublen--) { //在dp矩阵种由长至短寻找最长的回文子串
			for(int i=0;i<len-sublen+1;i++) {
				int j = i+sublen-1;
				if(dp[i][j]==1) {
					start = i;
					end = j;
					break Label;   //寻找到的话即为最大，跳出整个循环
				}
			}
		}
		
		String result = s.substring(start,end+1);//不包括尾
		return result;
	}
	
	
	
	public void test() {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
}
