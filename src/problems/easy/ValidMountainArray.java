package problems.easy;

/**
 * @author zyuanyuz
 * @since 2020/11/3 9:43
 */

/**
 * leetcode 941
 */

public class ValidMountainArray {
    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 41.65%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 64.39%
     * 的用户
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int upEnd = -1, downStart = A.length;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] == A[i]) {
                return false;
            }
            if (A[i + 1] < A[i]) {
                upEnd = i;
                break;
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i - 1] == A[i]) {
                return false;
            }
            if (A[i - 1] < A[i]) {
                downStart = i;
                break;
            }
        }
        return upEnd == downStart;
    }

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();
        v.validMountainArray(new int[]{0,3,2,1});
    }
}
