package problems.offer;

import java.util.Arrays;

public class P61 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 88.67% 的用户 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int jokerCount = 0, expectNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                jokerCount++;
            } else if (expectNum == 0) {
                expectNum = nums[i] + 1;
            } else if (expectNum != nums[i]) {
                while (expectNum != nums[i]) {
                    if (jokerCount > 0) {
                        jokerCount--;
                        expectNum++;
                    } else {
                        return false;
                    }
                }
                expectNum++;
            } else {
                expectNum++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P61 p = new P61();
        System.out.println(p.isStraight(new int[] { 0, 0, 3, 4, 7 }));
    }

}