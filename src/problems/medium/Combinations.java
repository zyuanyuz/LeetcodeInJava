package problems.medium;

import java.util.*;

/**
 * leetcode 77 Combinations Medium
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    //Runtime: 2 ms, faster than 96.42% of Java online submissions for Combinations.
    //Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Combinations.
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> nowList = new ArrayList<>();
        for (int i = 0; i < k; ) {
            nowList.add(++i);
        }
        backtracking(nowList, n, 1, k);
        return result;
    }

    public void backtracking(List<Integer> list, int N, int floor, int K) {
        if (floor == K + 1) {
            List<Integer> oneResult = new ArrayList<>(list);
            result.add(oneResult);
        } else {
            int startNum = floor == 1 ? 0 : list.get(floor - 2);  //this floor-2 should be watched out!
            for (int i = startNum; i < N - K + floor; i++) {
                list.set(floor - 1, i + 1);
                backtracking(list, N, floor + 1, K);
                list.set(floor - 1, i - 1);
            }
        }
    }

    public void test() {
        combine(4, 2);
        System.out.println(result);
    }
}
