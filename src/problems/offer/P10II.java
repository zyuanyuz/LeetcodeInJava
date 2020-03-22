package problems.offer;

public class P10II {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 36 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int numWays(int n) {
        long[] ways = new long[2];
        ways[0] = 1L;
        ways[1] = 2L;
        for (int count = 2; count < n; count++) {
            ways[count % 2] = (ways[count % 2] + ways[(count - 1) % 2]) % 1000000007;
        }
        return n > 0 ? (int) ways[(n - 1) % 2] : 1;
    }

    public static void main(String[] args) {
        P10II p = new P10II();
        p.numWays(7);
    }

}