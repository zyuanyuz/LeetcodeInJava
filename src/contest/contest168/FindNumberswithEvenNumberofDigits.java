package contest.contest168;

public class FindNumberswithEvenNumberofDigits {

    public int findNumbers(int[] nums) {
        int evenNumber = 0;
        int maxIndex = 0, maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 1; nums[maxIndex] != 0; i++) {
            boolean isEven = i % 2 == 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                nums[j] /= 10;
                if (nums[j] == 0 && isEven) {
                    evenNumber++;
                }
            }
        }
        return evenNumber;
    }

    public static void main(String[] args){
        int[] nums = new int[]{555,901,482,1771};
        FindNumberswithEvenNumberofDigits f = new FindNumberswithEvenNumberofDigits();
        f.findNumbers(nums);
    }
}