package problems.offer;

public class P66 {
    /**
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 8.84% 的用户 内存消耗 : 55.9 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] c = new int[a.length], d = new int[a.length];
        c[0] = 1;
        d[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            c[i] = c[i - 1] * a[i - 1];
            d[a.length - 1 - i] = d[a.length - i] * a[a.length - i];
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = c[i] * d[i];
        }
        return result;
    }

    public static void main(String[] args) {
        P66 p = new P66();
        p.constructArr(new int[] { 1, 2, 3, 4, 5 });
    }
}