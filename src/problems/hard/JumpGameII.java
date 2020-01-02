package problems.hard;

//leetcode 45
public class JumpGameII {
    /**
     * 
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] jump = new int[nums.length];
        jump[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            jump[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                if (jump[j] > jump[i] + 1) {
                    jump[j] = jump[i] + 1;
                }
            }
        }
        return jump[jump.length - 1];
    }
}