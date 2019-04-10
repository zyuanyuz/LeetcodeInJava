package problems.medium;

/**
 * leetcode 60 Medium
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 * In Number Value Order!
 */
public class PermutationSequence {

    int[] resultIntArray;
    int count;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;    //init the nums array
        }
        resultIntArray = new int[n];
        count = 0;
        backtracking(nums, 0, n, k);
        char[] resultCharArray = new char[n];
        for (int i = 0; i < n; i++) {
            resultCharArray[i] = (char) (resultIntArray[i] + '0');
            //System.out.println(resultIntArray[i]);
        }

        return String.valueOf(resultCharArray);
    }

    public void backtracking(int[] nums, int deep, int n, int k) {
        if (deep == n) {
            count++;
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            if (count == k) {
                if (n >= 0) System.arraycopy(nums, 0, resultIntArray, 0, n);
            }
        } else if (count < k) {
            for (int i = deep; i < n; i++) {
                int tmp = nums[deep];
                nums[deep] = nums[i];
                nums[i] = tmp;
                backtracking(nums, deep + 1, n, k);
                tmp = nums[deep];
                nums[deep] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public void test() {
        System.out.println("result:" + getPermutation(4, 16));
    }
}
