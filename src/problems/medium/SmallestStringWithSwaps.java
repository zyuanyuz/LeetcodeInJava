package problems.medium;

/**
 * @author zyuanyuz
 * @since 2021/1/11 10:14
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 1202
 */
public class SmallestStringWithSwaps {
    /**
     * 执行用时：
     * 33 ms
     * , 在所有 Java 提交中击败了
     * 90.10%
     * 的用户
     * 内存消耗：
     * 88.3 MB
     * , 在所有 Java 提交中击败了
     * 18.48%
     * 的用户
     *
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] sChars = new char[s.length()];
        int[] parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        Map<Integer, Set<Integer>> pairMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int p = find(parent, i);
            if (!pairMap.containsKey(p)) {
                pairMap.put(p, new HashSet<>());
            }
            pairMap.get(p).add(i);
        }
        for (Set<Integer> indexs : pairMap.values()) {
            sortChars(sChars, indexs, s);
        }
        return new String(sChars);
    }

    private void sortChars(char[] sChars, Set<Integer> indexs, String s) {
        char[] chars = new char[indexs.size()];
        int[] newIndex = new int[indexs.size()];
        int i = 0;
        for (int index : indexs) {
            chars[i] = s.charAt(index);
            newIndex[i] = index;
            i++;
        }
        Arrays.sort(chars);
        Arrays.sort(newIndex);
        for (int n = 0; n < newIndex.length; n++) {
            sChars[newIndex[n]] = chars[n];
        }
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps s = new SmallestStringWithSwaps();
        String str = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 3));
        System.out.println(s.smallestStringWithSwaps(str, pairs));
    }
}
