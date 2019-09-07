package problems.easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * leetcode 118 PascalsTriangle easy
 */
public class PascalsTriangle {
    //Runtime: 1 ms, faster than 20.25% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 33.8 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        List<Integer> oneResult = Arrays.asList(1);
        result.add(oneResult);
        for (int i = 1; i < numRows; i++) {
            oneResult = new ArrayList<Integer>();
            oneResult.add(1);
            for (int j = 1; j < i; j++) {
                oneResult.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            oneResult.add(1);
            result.add(oneResult);
        }
        return result;
    }
}