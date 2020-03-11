package problems.offer;

public class P13 {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 56.17% 的用户 内存消耗 : 36.8 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] reach = new boolean[m][n];
        int[] mArray = new int[m], nArray = new int[n];

        for (int i = 0; i < m; i++) {
            int tmp = i;
            while (tmp != 0) {
                mArray[i] += tmp % 10;
                tmp /= 10;
            }
        }
        for (int i = 0; i < n; i++) {
            int tmp = i;
            while (tmp != 0) {
                nArray[i] += tmp % 10;
                tmp /= 10;
            }
        }

        backTracing(reach, 0, 0, mArray, nArray, k);

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j])
                    count++;
            }
        }
        return count;
    }

    void backTracing(boolean[][] reach, int i, int j, int[] mArray, int[] nArray, int k) {
        if (reach[i][j]) {
            return;
        }
        reach[i][j] = true;
        if (i > 0 && mArray[i - 1] + nArray[j] <= k) {
            backTracing(reach, i - 1, j, mArray, nArray, k);
        }
        if (i < reach.length - 1 && mArray[i + 1] + nArray[j] <= k) {
            backTracing(reach, i + 1, j, mArray, nArray, k);
        }
        if (j > 0 && mArray[i] + nArray[j - 1] <= k) {
            backTracing(reach, i, j - 1, mArray, nArray, k);
        }
        if (j < reach[0].length - 1 && mArray[i] + nArray[j + 1] <= k) {
            backTracing(reach, i, j + 1, mArray, nArray, k);
        }
    }

    public static void main(String[] args) {
        P13 p = new P13();
        System.out.println(p.movingCount(15, 15, 12));
    }
}