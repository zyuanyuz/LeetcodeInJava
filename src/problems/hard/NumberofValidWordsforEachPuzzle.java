package problems.hard;

import java.util.*;

/**
 * leetcode 1178 hard
 */

public class NumberofValidWordsforEachPuzzle {
    /**
     * 执行用时：
     * 233 ms
     * , 在所有 Java 提交中击败了
     * 10.87%
     * 的用户
     * 内存消耗：
     * 54.9 MB
     * , 在所有 Java 提交中击败了
     * 16.30%
     * 的用户
     *
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Integer[] result = new Integer[puzzles.length];
        Map<Integer, Integer> wordsBitsMap = new HashMap<>();
        for (String word : words) {
            int wordBit = computeBit(word);
            wordsBitsMap.put(wordBit, wordsBitsMap.getOrDefault(wordBit, 0) + 1);
        }
        for (int i = 0; i < puzzles.length; i++) {
            result[i] = 0;
            backTracking(result, i, 0, 0, new HashSet<>(), puzzles[i], wordsBitsMap);
        }
        return Arrays.asList(result);
    }

    private int computeBit(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            int tmp = 1 << (26 - (c - 'a') - 1);
            result = result | tmp;
        }
        return result;
    }

    private void backTracking(Integer[] result, int i, int level,
                              int sub, Set<Integer> subSetLog, String str, Map<Integer, Integer> wordBitMap) {
        if (level == 0) {
            int firstSub = 1 << (25 - (str.charAt(0) - 'a'));
            if (wordBitMap.containsKey(firstSub)) {
                result[i] += wordBitMap.get(firstSub);
            }
            subSetLog.add(firstSub);
            backTracking(result, i, level + 1, firstSub, subSetLog, str, wordBitMap);
        } else if (level < str.length()) {
            //ignore the char first
            if (!subSetLog.contains(sub) && wordBitMap.containsKey(sub)) {
                result[i] += wordBitMap.get(sub);
                subSetLog.add(sub);
            }
            backTracking(result, i, level + 1, sub, subSetLog, str, wordBitMap);

            sub |= 1 << (25 - (str.charAt(level) - 'a'));
            if (!subSetLog.contains(sub) && wordBitMap.containsKey(sub)) {
                result[i] += wordBitMap.get(sub);
                subSetLog.add(sub);
            }
            backTracking(result, i, level + 1, sub, subSetLog, str, wordBitMap);
        }
    }

    public static void main(String[] args) {

    }
}
