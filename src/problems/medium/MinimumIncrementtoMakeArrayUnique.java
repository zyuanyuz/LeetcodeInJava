package problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 945
 */
public class MinimumIncrementtoMakeArrayUnique {
    /**
     * 执行用时 : 788 ms , 在所有 Java 提交中击败了 10.94% 的用户 内存消耗 : 46.6 MB , 在所有 Java 提交中击败了
     * 93.10% 的用户
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int incCount = 0;
        for (int i = 0; i < A.length; i++) {
            int pivot = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] == pivot) {
                    A[j]++;
                    incCount++;
                } else
                    break;
            }
        }
        return incCount;
    }

    public static void main(String[] args) {
        MinimumIncrementtoMakeArrayUnique m = new MinimumIncrementtoMakeArrayUnique();
        System.out.println(m.minIncrementForUnique(
                new int[] { 2, 3, 4, 3, 1, 4, 5, 3, 5, 4, 3, 3, 2, 6, 7, 4, 4, 5, 6, 7, 8, 6, 6, 4, 7, 7, 8, 6 }));
    }
}