package problems.hard;

import java.util.*;

/**
 * leetcode 140 WordBreakII hard
 */

public class WordBreakII {
    // Runtime: 41 ms, faster than 5.67% of Java online submissions for Word Break
    // II.
    // Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Word
    // Break II.
    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        boolean[] isReachable = new boolean[s.length()];
        label: for (int preIndex = 0; preIndex < s.length();) {
            for (String word : wordDict) {
                int lastIndex = word.length() + preIndex;
                if (lastIndex <= s.length() && s.substring(preIndex, lastIndex).equals(word)) {
                    isReachable[lastIndex - 1] = true;
                }
            }
            for (; preIndex < s.length();) {
                preIndex++;
                if (isReachable[preIndex - 1]) {
                    break;
                }
            }
        }
        for (int i = 0; i < isReachable.length; i++) {
            System.out.print(isReachable[i] + " ");
        }
        if (isReachable[isReachable.length - 1]) {
            makeWordBreak(new ArrayList<>(), isReachable, wordDict, 0, s);
        }
        return result;
    }

    private void makeWordBreak(List<String> oneResult, boolean[] isReachable, List<String> wordDict, int index,
            String s) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            oneResult.forEach(result -> sb.append(result).append(" "));
            result.add(sb.toString().trim());
        }
        for (int i = index + 1; i <= isReachable.length; i++) {
            if (isReachable[i - 1] && wordDict.contains(s.substring(index, i))) {
                oneResult.add(s.substring(index, i));
                makeWordBreak(oneResult, isReachable, wordDict, i, s);
                oneResult.remove(oneResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wBreak = new WordBreakII();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaa");
        System.out.println(wBreak.wordBreak(s, wordDict));
    }
}
// "catsanddog"
// ["cat","cats","and","sand","dog"]

// "catsandog"
// ["cats", "dog", "sand", "and", "cat"]

// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]