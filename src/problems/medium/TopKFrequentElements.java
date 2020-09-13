package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
/**
 * leetcode 347
 */
public class TopKFrequentElements {
    /*
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 60.91% 的用户 内存消耗： 42.4 MB , 在所有 Java 提交中击败了
     * 51.83% 的用户
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            queue.offer(new Node(entry.getKey(), entry.getValue()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).key;
        }
        return result;
    }

    private class Node implements Comparable<Node> {
        int key;
        int count;

        Node(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }
    }
}
