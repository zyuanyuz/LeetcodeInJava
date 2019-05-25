package problems.medium;

import java.util.*;

/**
 * leetcode 120 Triangle Medium
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 */
public class Triangle {
    //Runtime: 6 ms, faster than 16.54% of Java online submissions for Triangle.
    //Memory Usage: 36.3 MB, less than 98.50% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(triangle.get(i).size() - 1, triangle.get(i).get(triangle.get(i).size() - 1)
                            + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j)
                            + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        int lastLength = triangle.get(triangle.size() - 1).size();
        // System.out.println(triangle.get(triangle.size() - 1));
        for (int i = 0; i < lastLength; i++) {
            result = triangle.get(triangle.size() - 1).get(i) < result ? triangle.get(triangle.size() - 1).get(i)
                    : result;
        }
        return result;
    }

    // [[-1],[2,3],[1,-1,-3]]
}