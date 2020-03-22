package problems.offer;

public class P14II {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 36 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = (int) 1e9 + 7;
        int three = n / 3;
        if (n - three * 3 == 1) {
            three -= 1;
        }
        int two = (n - three * 3) / 2;
        long result = 1L;
        while (three > 0) {
            result *= 3;
            result %= mod;
            three--;
        }
        result *= (long) Math.pow(2, two);
        return (int) (result % mod);
    }

    public static void main(String[] args) {
        P14II p = new P14II();
        System.out.println(p.cuttingRope(209));
    }
}