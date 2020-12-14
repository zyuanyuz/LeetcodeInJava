package problems.medium;

/**
 * @author zyuanyuz
 * @since 2020/12/12 14:58
 */

import java.util.LinkedList;

/**
 * leetcode 649
 */
public class Dota2Senate {
    /**
     * 执行用时：
     * 15 ms
     * , 在所有 Java 提交中击败了
     * 27.91%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 26.57%
     * 的用户
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> DList = new LinkedList<>(), RList = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                DList.addLast(i);
            } else {
                RList.addLast(i);
            }
        }
        int i = 0;
        while (DList.size() > 0 && RList.size() > 0) {
            if (senate.charAt(i) == 'D' && DList.peekFirst() == i) {
                RList.pollFirst();
                DList.addLast(DList.pollFirst());
            } else if (senate.charAt(i) == 'R' && RList.peekFirst() == i) {
                DList.pollFirst();
                RList.addLast(RList.pollFirst());
            }
            i++;
            i %= senate.length();
        }
        return DList.size() == 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();
        System.out.println(d.predictPartyVictory("DDRRR"));
    }
}
