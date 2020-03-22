package problems.offer;

import java.util.Arrays;

public class P40 {
    /**
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 56.25% 的用户 内存消耗 : 42.7 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}