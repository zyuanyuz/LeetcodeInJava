package problems.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode 146 LRUCache Medium

public class LRUCache {
    /**
     * 执行用时 : 171 ms , 在所有 Java 提交中击败了 12.22% 的用户 内存消耗 : 64.4 MB , 在所有 Java 提交中击败了
     * 60.85% 的用户
     */
    Map<Integer, Integer> cacheMap = new HashMap<>();
    LinkedList<Integer> cacheKeyList = new LinkedList<>();
    final int listCapacity;

    public LRUCache(int capacity) {
        this.listCapacity = capacity;
    }

    public int get(int key) {
        if (!cacheMap.keySet().contains(key)) {
            return -1;
        }
        cacheKeyList.remove((Integer) key);
        cacheKeyList.addFirst(key);
        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            cacheMap.put(key, value);
            return;
        }
        if (cacheMap.size() == listCapacity) {
            int keyToDelete = cacheKeyList.removeLast();
            cacheMap.remove(keyToDelete);
        }
        cacheKeyList.addFirst(key);
        cacheMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1); // 返回 1
        cache.put(3, 3); // 该操作会使得密钥 2 作废
        cache.get(2); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得密钥 1 作废
        cache.get(1); // 返回 -1 (未找到)
        cache.get(3); // 返回 3
        cache.get(4); // 返回 4

    }
}