package problems.medium;

import java.util.PriorityQueue;

/**
 * @author zyuanyuz
 * @since 2020/11/9 15:02
 */

/**
 * leetcode 973
 */
public class KClosestPointstoOrigin {
    /**
     * 执行用时：
     * 25 ms
     * , 在所有 Java 提交中击败了
     * 68.84%
     * 的用户
     * 内存消耗：
     * 47.1 MB
     * , 在所有 Java 提交中击败了
     * 57.30%
     * 的用户
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        for (int[] point : points) {
            queue.offer(point);
        }
        K = Math.min(K, points.length);
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
