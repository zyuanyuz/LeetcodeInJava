package contest.contest171;

//leetcode 5307
public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    //bug in leetcode
    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        return new int[] { left, n - left };
    }
}