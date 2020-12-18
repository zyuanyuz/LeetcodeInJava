package problems.easy;

/**
 * @author zyuanyuz
 * @since 2020/12/18 12:45
 */

/**
 * leetcode 389
 */

public class FindtheDifference {
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.7 MB
     * , 在所有 Java 提交中击败了
     * 82.89%
     * 的用户
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] cCount = new int[26];
        for (char c : s.toCharArray()) {
            cCount[(int)(c - 'a')]++;
        }
        for (char c : t.toCharArray()) {
            cCount[(int)(c - 'a')]--;
        }
        for (int i = 0;i<cCount.length;i++) {
            if (cCount[i] < 0) {
                return (char)('a' + i);
            }
        }
        return 'A';
    }

    public static void main(String[] args) {
        FindtheDifference f = new FindtheDifference();
        String s = "abcd";
        String t = "abcde";
        System.out.println(f.findTheDifference(s,t));
    }
}
