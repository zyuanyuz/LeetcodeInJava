package contest.contest177;

public class ClosestDivisors {

    /**
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 37 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     * 
     * @param num
     * @return
     */
    public int[] closestDivisors(int num) {
        int maxOne = (int) Math.sqrt(num + 1);
        int maxTwo = (int) Math.sqrt(num + 2);

        int[] result = new int[] { 0, 0 };
        int distance = Integer.MAX_VALUE;

        for (int i = maxOne; i > 0; i--) {
            if ((num + 1) % i == 0) {
                if (result[0] == 0) {
                    result[0] = i;
                    result[1] = (int) ((num + 1) / i);
                    distance = Math.abs(result[0] - result[1]);
                    break;
                }
            }
        }

        int tmp;
        for (int i = maxTwo; i > 0; i--) {
            if ((num + 2) % i == 0) {
                if (result[0] == 0) {
                    result[0] = i;
                    result[1] = (int) ((num + 2) / i);
                } else if (distance > Math.abs((i - (tmp = (int) ((num + 2) / i))))) {
                    result[0] = i;
                    result[1] = tmp;
                }
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ClosestDivisors c = new ClosestDivisors();
        for (int n : c.closestDivisors(999)) {
            System.out.print(n + " ");
        }
    }
}