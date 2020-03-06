package problems.offer;

import java.util.ArrayList;
import java.util.List;

public class P57II {
    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 75.52% 的用户 内存消耗 : 36.9 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> listResult = new ArrayList<>();
        int a = 1, b = 2, sum = a + b;
        while (a < b) {
            if (sum < target) {
                b++;
                sum += b;
            } else if (sum > target) {
                sum -= a;
                a++;
            } else {
                int[] oneResult = new int[b - a + 1];
                for (int i = 0; i <= b - a; i++) {
                    oneResult[i] = a + i;
                }
                listResult.add(oneResult);
                b++;
                sum += b;
            }
        }
        return listResult.stream().toArray(int[][]::new);
    }

    public static void main(String[] args) {
        P57II p = new P57II();
        p.findContinuousSequence(9);
    }
}