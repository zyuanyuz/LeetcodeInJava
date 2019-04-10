package problems.easy;

import java.util.Arrays;

/**
 * leetcode 66 PlusOne Easy
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
    //Memory Usage: 35 MB, less than 69.57% of Java online submissions for Plus One.
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }
        int upCount = 0, i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                upCount = 1;
                continue;
            } else {
                digits[i]++;
                upCount = 0;
                break;
            }
        }
        if (upCount == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        } else {
            return digits;
        }

    }

    public void test() {
        //[8,9,9,9]
        int[] digits = new int[]{};
        for (int num : plusOne(digits)) {
            System.out.print(num + "\t");
        }
    }
}
