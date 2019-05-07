package problems.medium;

import java.util.*;

/**
 * leetcode 129 PalindromePartitioning Medium
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * See leetcode 5 
 */
public class PalindromePartitioning {
    // Runtime: 2 ms, faster than 99.21% of Java online submissions for Palindrome
    // Partitioning.
    // Memory Usage: 37.8 MB, less than 95.47% of Java online submissions for
    // Palindrome Partitioning.
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                if (length == 1)
                    isPalindrome[i][i + length - 1] = true;
                else if (length == 2)
                    isPalindrome[i][i + length - 1] = (s.charAt(i) == s.charAt(i + length - 1));
                else if (s.charAt(i) == s.charAt(i + length - 1))
                    isPalindrome[i][i + length - 1] = isPalindrome[i + 1][i + length - 2];
                else
                    isPalindrome[i][i + length - 1] = false;
            }
        }

        backtracking(result, new ArrayList<>(), isPalindrome, 0, s);
        return null;
    }

    void backtracking(List<List<String>> result, List<String> tmpList, boolean[][] isPalin, int index, String s) {
        if (index == s.length()) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (isPalin[index][i]) {
                    tmpList.add(s.substring(index, i + 1));
                    backtracking(result, tmpList, isPalin, i + 1, s);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

}