package problems.easy;

/**
 * leetcode 38 Easy
 *
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
    //Runtime: 2 ms, faster than 96.93% of Java online submissions for Count and Say.
    //Memory Usage: 36.7 MB, less than 80.42% of Java online submissions for Count and Say.
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder lastResultString = new StringBuilder("1");
        int i = 1, j = 0, sameCount = 1;
        for (; i < n; i++) {
            StringBuilder tmpString = new StringBuilder();
            j = 0;
            int lastStringLength = lastResultString.length();
            while (j < lastStringLength) {
                if (j < (lastStringLength - 1)
                        && lastResultString.charAt(j) == lastResultString.charAt(j + 1)) {
                    sameCount++;
                }else{
                    tmpString.append(sameCount);
                    tmpString.append(lastResultString.charAt(j));
                    sameCount = 1;
                }
                j++;
            }
            lastResultString = tmpString;
        }
        return lastResultString.toString();
    }

    public void test() {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
