package problems.offer;

public class P14I {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 12.42% 的用户 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int cuttingRope(int n) {
        int[] maxValue = new int[n + 1];
        maxValue[0] = 0;
        maxValue[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int maxCount = 0;
            for (int j = 1; j < i; j++) {
                if (Math.max(j, maxValue[j]) * Math.max(i - j, maxValue[i - j]) > maxCount) {
                    maxCount = Math.max(j, maxValue[j]) * Math.max(i - j, maxValue[i - j]);
                }
            }
            maxValue[i] = maxCount;
        }
        return maxValue[n];
    }

    public static void main(String[] args) {
        P14I p = new P14I();
        System.out.println(p.cuttingRope(10));
    }
}