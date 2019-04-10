package problems.medium;

import java.util.*;

/**
 * leetcode 89 GrayCode Medium
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {
    //Runtime: 1 ms, faster than 40.77% of Java online submissions for Gray Code.
    //Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Gray Code.
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        backtracking(result, str, 0, n);
        return result;
    }

    private void backtracking(List<Integer> result, StringBuilder str, int n, int N) {
        if (n == N) {
            result.add(Integer.valueOf(str.toString(), 2));
        } else {
            backtracking(result, str, n + 1, N);
            str.setCharAt(n, str.charAt(n) == '0' ? '1' : '0');
            backtracking(result, str, n + 1, N);
        }
    }

    public void test() {
        List<Integer> result = grayCode(2);
        for (int num : result) {
            System.out.print(num + "\t");
        }
    }
}
