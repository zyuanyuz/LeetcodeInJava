package contest.contest169;

public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) { // n is an even number
            for (int num = 0 - n / 2, i = 0; i < result.length; num++) {
                if (num == 0)
                    continue;
                result[i] = num;
                i++;
            }
        } else {
            for (int num = 0 - n / 2, i = 0; i < result.length; num++, i++) {
                result[i] = num;
            }
        }
        return result;
    }
}