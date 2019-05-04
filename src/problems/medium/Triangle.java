package problems.medium;

import java.util.*;

/**
 * 
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 */
public class Triangle {
    //

    int minSum = Integer.MAX_VALUE;
    int tmpSum = 0;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int[] indexs = new int[triangle.size()];
        indexs[0] = 0; // is right?
        tmpSum = triangle.get(0).get(0);
        countNum(triangle, 0, 1);
        return this.minSum;
    }

    private void countNum(List<List<Integer>> triangle, int lastIndex, int n) {
        if (n == triangle.size()) {
            if (tmpSum < minSum)
                minSum = tmpSum;
        } else {
            List<Integer> numList = triangle.get(n);
            for (int i = lastIndex; i <= lastIndex + 1; i++) { //2 ways
                tmpSum += numList.get(i);
                if (tmpSum < minSum) {
                    countNum(triangle, i, n + 1);
                }
                tmpSum -= numList.get(i);
            }
        }
    }

    //[[-1],[2,3],[1,-1,-3]]
}