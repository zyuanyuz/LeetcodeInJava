package problems.offer;

import java.util.HashMap;
import java.util.Map;

public class P48 {
    /**
     * 执行用时：8 ms 内存消耗：39.8 MB
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charMap.keySet().contains(s.charAt(i)) && charMap.get(s.charAt(i)) >= startIndex) {
                startIndex = charMap.get(s.charAt(i)) + 1;
            } else {
                endIndex = i;
                maxLength = endIndex - startIndex + 1 > maxLength ? endIndex - startIndex + 1 : maxLength;
            }
            charMap.put(s.charAt(i), i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        P48 p = new P48();
        p.lengthOfLongestSubstring("abcabcbb");
    }

}