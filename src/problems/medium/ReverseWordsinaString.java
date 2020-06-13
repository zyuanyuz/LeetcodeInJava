package problems.medium;

/**
 * leetcode 151
 */
public class ReverseWordsinaString {
    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.99% 的用户 内存消耗 : 40 MB , 在所有 Java 提交中击败了 5.26%
     * 的用户
     */
    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        StringBuilder strB = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (!strArray[i].isEmpty()) {
                strB.append(strArray[i]).append(" ");
            }
        }
        if (strB.length() > 1) {
            strB.deleteCharAt(strB.length() - 1);
        }
        return strB.toString();
    }
}