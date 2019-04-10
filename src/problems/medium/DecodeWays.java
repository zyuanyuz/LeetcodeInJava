package problems.medium;

/**
 * leetcode 91 DecodeWays Medium
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

//    int result = 0;
//
//    public int numDecodings(String s) {
//        if (s.equals("")) {
//            return 0;
//        }
//        backtracking(s, 0);
//        return result;
//    }
//
//    private void backtracking(String s, int index) {
//        if (index == s.length()) {
//            result++;
//        } else if (s.charAt(index) != '0') {
//            index++;
//            backtracking(s, index);
//            index--;
//            if (index <= s.length() - 2 && Integer.valueOf(s.substring(index, index + 2)) <= 26) {
//                index += 2;
//                backtracking(s, index);
//            }
//        }
//    }

    //Runtime: 2 ms, faster than 45.59% of Java online submissions for Decode Ways.
    //Memory Usage: 36.9 MB, less than 25.57% of Java online submissions for Decode Ways.
    public int numDecodings(String s) {
        if (s.equals("")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        dp[0] = dp[1];
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                dp[i] = dp[i - 2];
            } else if (s.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 2) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = Integer.valueOf(s.substring(i - 2, i)) <= 26 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public void test() {
        // 0
        // 10
        // 30123120123
        // 1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565
        // 100
        System.out.println("\n" + numDecodings("100"));
    }
}
