package problems.medium;

import java.util.HashSet;
import java.util.List;

/**
 * leetcode 841 Medium
 */
public class KeysandRooms {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 76.33% 的用户 内存消耗： 39.7 MB , 在所有 Java 提交中击败了
     * 57.22% 的用户
     * 
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> canReach = new HashSet<>();
        canReach.add(0);

        dfsReach(0, rooms, canReach);

        for (int i = 0; i < rooms.size(); i++) {
            if (!canReach.contains(i)) {
                return false;
            }
        }
        return true;
    }

    void dfsReach(int nowIndex, List<List<Integer>> rooms, HashSet<Integer> canReach) {
        List<Integer> keys = rooms.get(nowIndex);
        for (int key : keys) {
            if (!canReach.contains(key)) {
                canReach.add(key);
                dfsReach(key, rooms, canReach);
            }
        }
    }
}