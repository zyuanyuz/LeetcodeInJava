package problems.medium;

/**
 * leetcode 395 medium
 */

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 90.03%
     * 的用户
     * 内存消耗：
     * 36.3 MB
     * , 在所有 Java 提交中击败了
     * 81.09%
     * 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        //System.out.println("range " + l + " " + r);
        int[] charCount = new int[26];
        for (int i = l; i <= r; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        char splitChar = (char) ('a' - 1);  // init the split char
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0 && charCount[i] < k) {
                splitChar = (char) ('a' + i);
                break;
            }
        }
        //System.out.println(splitChar);
        if (splitChar == (char) ('a' - 1)) {  // all char count reach k
            return r - l + 1;
        }
        int maxLength = 0;
        int subL = l - 1, subR = l - 1;
        while (subR < r + 1) {
            subR++;
            if (subR == r + 1 || s.charAt(subR) == splitChar) {
                if (subL == l && subR == r) {
                    continue;
                }
                if (subR - subL - 1 >= k) {
                    //System.out.println(splitChar + " " + subL + " " + subR);
                    maxLength = Math.max(maxLength, dfs(s, subL + 1, subR - 1, k));
                    //System.out.println("here : " + maxLength);
                }
                subL = subR;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtLeastKRepeatingCharacters l = new LongestSubstringwithAtLeastKRepeatingCharacters();
        String s = "aaabbbcdefcdefgggggggggggggggcde";
        int k = 3;
        System.out.println(l.longestSubstring(s, k));
    }
}
