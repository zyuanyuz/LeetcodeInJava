package problems.medium;

import java.util.ArrayList;

/**
 * leetcode 43 Medium
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1: Input: num1 = "2", num2 = "3" Output: "6"
 * <p>
 * Example 2: Input: num1 = "123", num2 = "456" Output: "56088"
 * <p>
 * Note:1.The length of both num1 and num2 is < 110. 2.Both num1 and num2
 * contain only digits 0-9. 3.Both num1 and num2 do not contain any leading
 * zero, except the number 0 itself. 4.You must not use any built-in BigInteger
 * library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    //Runtime: 12 ms, faster than 87.57% of Java online submissions for Multiply Strings.
    //Memory Usage: 38.7 MB, less than 51.00% of Java online submissions for Multiply Strings.
    public String multiply(String num1, String num2) {
        if (num1.equals("") || num2.equals("")) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int[] tmpResult = new int[num1.length() + num2.length()];
        int upCount = 0;
        int offset = num1.length() + num2.length() - 1, offsetj = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                offsetj = num2.length() - 1 - j;
                int nowNum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0')
                        + tmpResult[offset - offsetj] + upCount;
                //System.out.println(nowNum);
                upCount = nowNum / 10;
                tmpResult[offset - offsetj] = nowNum % 10;
            }
            while (upCount > 0) {
                int nowNum = tmpResult[offset - offsetj - 1] + upCount;
                upCount = nowNum / 10;
                tmpResult[offset - offsetj - 1] = nowNum % 10;
                offsetj++;
            }
            offset--;
        }
        int i = 0;
        while (i < tmpResult.length - 1 && tmpResult[i] == 0) i++;
        for (int j = i; j < tmpResult.length; j++) {
            result.append(tmpResult[j]);
        }
        return result.toString();
    }

    public void test() {
        //0 0
        //
        System.out.println(multiply("0", "0"));
    }
}
