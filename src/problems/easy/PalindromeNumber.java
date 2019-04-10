package problems.easy;

/**
 * leetcode 9 Easy
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 */
/*优化思路：只记录后半部分数字，且无需将其转化为string*/
//154 ms, faster than 27.68% of Java online submissions for Palindrome Number.
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		Integer tmp = x;
		String xstr = tmp.toString();
		int i = 0, j = xstr.length() - 1;
		while (i < j) {
			if (xstr.charAt(i) == xstr.charAt(j)) {
				i++;
				j--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public void testCase() {
		if (isPalindrome(10)) {
			System.out.println("ok!");
		}
		else{
			System.out.println("no!");
		}
	}
}
