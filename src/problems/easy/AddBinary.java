package problems.easy;

/**
 * leetcode 67 AddBinary Easy
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    //Runtime: 1 ms, faster than 99.96% of Java online submissions for Add Binary.
    //Memory Usage: 34.4 MB, less than 99.83% of Java online submissions for Add Binary.
    public String addBinary(String a, String b) {
        int x, y = a.length() - 1, z = b.length() - 1, up = 0;
        char[] resultCharArray = new char[Math.max(y, z) + 2];
        for (x = resultCharArray.length - 1; y >= 0 && z >= 0; x--, y--, z--) {
            int num = (a.charAt(y) - '0') + (b.charAt(z) - '0') + up;
            up = num / 2;
            resultCharArray[x] = (char) (num % 2 + '0');
        }
        if (y != z) {
            String c = y > z ? a.substring(0, y + 1) : b.substring(0, z + 1);
            for (int i = c.length() - 1; i >= 0; x--, i--) {
                int num = (c.charAt(i) - '0') + up;
                up = num / 2;
                resultCharArray[x] = (char) (num % 2 + '0');
            }
        }
        resultCharArray[x] = (char) (up + '0');
//        for (int i = 0; i < resultCharArray.length; i++) {
//            System.out.print(resultCharArray[i] + "\t");
//        }
        if (resultCharArray[0] == '1') {
            return String.valueOf(resultCharArray);
        } else {
            return String.valueOf(resultCharArray).substring(1, resultCharArray.length);
        }
    }

    public void test() {
        System.out.println(addBinary("11", "11"));
    }
}
