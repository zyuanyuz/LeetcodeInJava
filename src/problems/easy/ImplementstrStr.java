package problems.easy;

/**
 * leetcode 28 easy
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2
 * 
 * Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1
 * 
 * when haystack is empty return -1,needle is empty return 0.
 *
 */
public class ImplementstrStr {
	//19 ms, faster than 14.12% of Java online submissions for Implement strStr().
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int[] pi = getPi(needle);
//		for (int i = 0; i < pi.length; i++) {
//			System.out.print(pi[i] + " ");
//		}
		int len = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while (needle.charAt(len) != haystack.charAt(i) && len != 0) {
				len = pi[len - 1];
			}
			if (needle.charAt(len) == haystack.charAt(i)) {
				len++;
			}
			if (len == needle.length()) {
				return i - len + 1;
			}
		}
		return -1;
	}

	// kmp from CLRS
	public int[] getPi(String needle) {
		int k = 0; // 匹配的长度
		int[] pi = new int[needle.length()];
		pi[0] = 0;
		for (int i = 1; i < needle.length(); i++) {

			while (needle.charAt(k) != needle.charAt(i) && k != 0) {
				k = pi[k - 1];
			}
			if (needle.charAt(k) == needle.charAt(i)) {
				k++;
			}
			pi[i] = k;
		}
		return pi;
	}

	public void test() {
		String haystack = "hello";
		String needle = "ll";
		System.out.println(strStr(haystack, needle));
	}
}
