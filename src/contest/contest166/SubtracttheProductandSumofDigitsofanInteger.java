package contest.contest166;

public class SubtracttheProductandSumofDigitsofanInteger {

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            product *= num;
            sum += num;
            n = n / 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        SubtracttheProductandSumofDigitsofanInteger s = new SubtracttheProductandSumofDigitsofanInteger();
        System.out.println(s.subtractProductAndSum(4421));
        System.out.println(s.subtractProductAndSum(2002));
        System.out.println(s.subtractProductAndSum(90009));
        System.out.println(s.subtractProductAndSum(99999));
    }

}