package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyuanyuz
 * @since 2021/1/14 12:58
 */

public class BinaryPrefixDivisibleBy5 {
    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 36.59%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 6.87%
     * 的用户
     *
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        int rest = 0;
        for (int j : A) {
            rest = rest * 2 % 5;
            rest += j;
            if (rest % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 b = new BinaryPrefixDivisibleBy5();
        List<Boolean> r = b.prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0});
    }
}
