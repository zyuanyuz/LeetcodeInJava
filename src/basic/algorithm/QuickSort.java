package basic.algorithm;

public class QuickSort {

    public static void main(String args[]) {
        int[] nums = new int[] { 2, 5, 1, 3, 4, 9, 6, 7 };
        quicksort(nums, 0, nums.length - 1);
        for (int var : nums) {
            System.out.println(var);
        }
    }

    private static void quicksort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = nums[end];
            int i = start - 1, j = start;
            for (; j < end; j++) {
                if (nums[j] < pivot) {
                    i++;
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
            int tmp = nums[i + 1];
            nums[i + 1] = pivot;
            nums[j] = tmp;
            quicksort(nums, start, i);
            quicksort(nums, i + 2, end);
        }
    }
}
