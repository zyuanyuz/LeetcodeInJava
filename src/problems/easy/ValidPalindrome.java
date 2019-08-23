package problems.easy;

/**
 * leetccode 125 ValidPalindrome Easy
 */

public class ValidPalindrome {
    //Runtime: 5 ms, faster than 54.69% of Java online submissions for Valid Palindrome.
    //Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < s.length() && !isCount(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isCount(s.charAt(j))) {
                j--;
            }
            if (i >= s.length() && j < 0) {
                return true;
            } else if (i < s.length() && j >= 0
                    && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isCount(char c){
        if(Character.isLetter(c)||Character.isDigit(c)){
            return true;
        }
        return false;
    }
}