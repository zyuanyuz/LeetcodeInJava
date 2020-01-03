package problems.hard;

//leetcode 44 WildcardMatching Hard

public class WildcardMatching {

    /**
     * 执行用时 : 25 ms , 在所有 Java 提交中击败了 20.61% 的用户 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了
     * 97.51% 的用户
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            if (p.length() == 0 || p.equals("*")) {
                return true;
            }
            return false;
        }
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        boolean[][] road = new boolean[p.length()][s.length()];
        boolean[] reservedArray = null; // indicate the reservedIndex that reserved by same char or ?
        // init the road
        if (p.charAt(0) == '*') {
            for (int j = 0; j < s.length(); j++) {
                road[0][j] = true;
            }
        } else if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
            road[0][0] = true;
            reservedArray = road[0];
        }

        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                int startIndex = 0;
                for (; startIndex < s.length(); startIndex++) {
                    if (road[i - 1][startIndex]) {
                        break;
                    }
                }
                for (int j = startIndex; j < s.length(); j++) {
                    road[i][j] = true;
                }
            } else { // p.charAt(i) == '?' or p.charAt(i) is a letter
                int startIndex = 0;
                for (int j = 0; reservedArray != null && j < reservedArray.length; j++) {
                    if (reservedArray[j]) {
                        startIndex = j + 1;
                        break;
                    }
                }
                for (int j = startIndex; j < s.length(); j++) {
                    if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
                        if (p.charAt(i - 1) == '*') {
                            road[i][j] = j > 0 ? road[i - 1][j - 1] || road[i - 1][j] : road[i - 1][j];
                        } else {

                            road[i][j] = j > 0 ? road[i - 1][j - 1] : false;
                        }
                    }
                }
                reservedArray = road[i];
            }
        }
        return road[p.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        System.out.println(w.isMatch("abab", "*a*ab"));
    }
    //
    // "mississippi"
    // "m??*ss*?i*pi"
}