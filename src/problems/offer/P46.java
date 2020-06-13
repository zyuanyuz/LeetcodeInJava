package problems.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P46 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 26.58% 的用户 内存消耗 : 36.5 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        int tmp = num;
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        while (tmp != 0) {
            list.add(0, tmp % 10);
            tmp /= 10;
        }
        backtracking(set, list, 0, new StringBuilder());
        return set.size();
    }

    void backtracking(Set<String> set, List<Integer> list, int index, StringBuilder sb) {
        if (index >= list.size()) {
            set.add(sb.toString());
        } else {
            int i = list.get(index);
            sb.append((char) (i + 'a'));
            backtracking(set, list, index + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb.toString());
            if (i > 0 && index + 1 < list.size() && i * 10 + list.get(index + 1) <= 25) {
                sb.append((char) (i * 10 + list.get(index + 1) + 'a'));
                backtracking(set, list, index + 2, sb);
                sb.delete(sb.length() - 1, sb.length());
                System.out.println(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        P46 p = new P46();
        p.translateNum(506);
    }
}