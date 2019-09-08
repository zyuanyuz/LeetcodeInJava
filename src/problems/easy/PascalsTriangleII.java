package problems.easy;

import java.util.List;
import java.util.ArrayList;

/**
 * leetcode 119 PascalsTriangleII easy
 */
public class PascalsTriangleII {
    //Runtime: 1 ms, faster than 89.12% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 33.6 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0)
            return result;
        result.add(1);
        if (rowIndex == 1)
            return result;
        for (int i = 2; i <= rowIndex; i++) {
            int tmpOne , tmpTwo = 1;
            for (int j = 1; j < i; j++) {
                tmpOne = tmpTwo;
                tmpTwo = result.get(j);
                result.set(j, tmpOne + tmpTwo);
            }
            result.add(1);
        }
        return result;
    }
}