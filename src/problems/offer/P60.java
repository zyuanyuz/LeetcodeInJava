package problems.offer;

public class P60 {

    /**
     * 执行用时 : 821 ms , 在所有 Java 提交中击败了 8.36% 的用户 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public double[] twoSum(int n) {
        int[] sumArray = new int[n * 5 + 1]; // n -> 6n

        fullSumArray(sumArray, n, 1, 0);

        int total = 0;
        for (int i = 0; i < sumArray.length; i++) {
            total += sumArray[i];
        }

        double[] result = new double[sumArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (double) sumArray[i] / (double) total;
        }

        return result;
    }

    void fullSumArray(int[] sumArray, int n, int floor, int upFloorSum) {
        if (floor == n) {
            for (int i = 1; i <= 6; i++) {
                sumArray[upFloorSum + i - n]++;
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                fullSumArray(sumArray, n, floor + 1, upFloorSum + i);
            }
        }
    }

    public static void main(String[] args) {
        P60 p = new P60();
        p.twoSum(2);
    }
}