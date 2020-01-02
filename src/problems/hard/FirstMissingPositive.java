package problems.hard;

import java.util.Arrays;

//leetcode 41 FirstMissingPositive Hard
public class FirstMissingPositive {

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 98.75% 的用户 内存消耗 : 34.9 MB , 在所有 java 提交中击败了
     * 85.89% 的用户
     * 
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int startIndex = 0;
        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i + 1 < nums.length && nums[i + 1] > 0) {
                startIndex = i + 1;
                break;
            }
            if (nums[i] == 1) {
                startIndex = i;
                break;
            }
        }
        for (; startIndex < nums.length; num++) {
            if (nums[startIndex] != num) {
                return num;
            }
            do {
                startIndex++;
            } while (startIndex < nums.length && nums[startIndex] == num);
        }
        return num;
    }
    // 0,2,2,1,1
    // 1,2,2,1,3,1,0,4,0

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        System.out.println(f.firstMissingPositive(new int[] { 0, 0, 0, 0, 0, 0 }));
    }
}