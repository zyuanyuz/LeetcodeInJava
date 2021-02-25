package problems.medium;

/**
 * leetcode 978 Medium
 */
public class LongestTurbulentSubarray {
    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 39.33%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 80.78%
     * 的用户
     *
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        boolean expected = false;
        boolean lastEqual = true;
        int nowLength = 1, maxLength = 1;
        if (arr.length < 2) {
            return 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                nowLength = 1;
                lastEqual = true;
            } else if (lastEqual) {
                nowLength = 2;
                expected = arr[i] < arr[i + 1];
                lastEqual = false;
            } else if (!(arr[i] < arr[i + 1]) == expected) {
                nowLength++;
                expected = arr[i] < arr[i + 1];
                //System.out.println(i + " nowLength:" + nowLength);
            } else {
                nowLength = 2;
                expected = arr[i] < arr[i + 1];
            }
            maxLength = Math.max(nowLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray l = new LongestTurbulentSubarray();
        int[] arr = new int[]{4, 8, 12, 16};
        System.out.println(l.maxTurbulenceSize(arr));
    }
}
