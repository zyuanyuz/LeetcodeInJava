package problems.medium;

import java.util.*;

/**
 * leetcode 93 RestoreIPAddresses Medium
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    //Runtime: 2 ms, faster than 84.80% of Java online submissions for Restore IP Addresses.
    //Memory Usage: 37.5 MB, less than 17.30% of Java online submissions for Restore IP Addresses.
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        backtracking(result, s, new StringBuilder(), 0, 0);
        return result;
    }

    public void backtracking(List<String> result, String s,
                             StringBuilder strBuilder, int index, int n) {
        if (n == 4) {
            result.add(strBuilder.toString());
        } else if (n == 3) {
            if ((s.length() - index <= 3 && s.length() - index >= 1) && ((Integer.valueOf(s.substring(index)) <= 255 && s.charAt(index) != '0')
                    || (Integer.valueOf(s.substring(index)) == 0 && s.length() - index == 1))) {
                strBuilder.append(s, index, s.length());
                backtracking(result, s, strBuilder, s.length() - 1, n + 1);
                strBuilder.delete(strBuilder.lastIndexOf("."), strBuilder.length());
            }
        } else if (index < s.length() && s.charAt(index) == '0') {
            strBuilder.append(s, index, index + 1);
            strBuilder.append(".");
            backtracking(result, s, strBuilder, index + 1, n + 1);
            strBuilder.deleteCharAt(strBuilder.length() - 1);  //remove the "."
            strBuilder.delete(n == 0 ? 0 : strBuilder.lastIndexOf(".") + 1,
                    strBuilder.length());
        } else if (index < s.length() && s.charAt(index) != '0') {
            for (int i = 1; i <= 3; i++) {
                if (s.length() - index > i
                        && Integer.valueOf(s.substring(index, index + i)) <= 255) {
                    strBuilder.append(s, index, index + i);
                    strBuilder.append(".");
                    backtracking(result, s, strBuilder, index + i, n + 1);
                    strBuilder.deleteCharAt(strBuilder.length() - 1);  //remove the "."
                    strBuilder.delete(n == 0 ? 0 : strBuilder.lastIndexOf(".") + 1,
                            strBuilder.length());
                }
            }
        } else {
            //do nothing when s contains two zero from index
        }
    }

    public void test() {
        // "010010"
        // "1111"
        // "111111"
        // "10010010"
        // "0279245587303"
        // "0000"
        // "00000"
        //  "000"
        List<String> result = restoreIpAddresses("00000");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
