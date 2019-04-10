package problems.easy;

/**
 * leetcode 58 Easy
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {
    //Runtime: 2 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    //Memory Usage: 37.4 MB, less than 12.36% of Java online submissions for Length of Last Word.
    public int lengthOfLastWord(String s) {
        s = s.trim();  //remove the white space in the start and end
        //s =s.stripTrailing();   //can use this in java 11
        return s.lastIndexOf(' ') == -1 ?
                s.length() : s.substring(s.lastIndexOf(' ') + 1, s.length()).length();
    }

    public void test() {
        String s = "Hello World  ";
        System.out.println(lengthOfLastWord(s));
    }
}
