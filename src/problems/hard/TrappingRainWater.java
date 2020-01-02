package problems.hard;

//leetcode 42 TrappingRainWater Hard
public class TrappingRainWater {
    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 99.98% 的用户 内存消耗 : 37.7 MB , 在所有 java 提交中击败了
     * 82.55% 的用户
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxValue) {
                maxValue = height[i];
                maxValueIndex = i;
            }
        }
        int resultCount = 0;
        // <-
        int wallIndex;
        for (int i = maxValueIndex; i > 0;) {
            wallIndex = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] >= height[wallIndex]) {
                    wallIndex = j;
                }
            }
            for (int j = wallIndex + 1; j < i; j++) {
                resultCount += (height[wallIndex] - height[j]);
            }
            i = wallIndex;
        }
        // ->
        for (int i = maxValueIndex; i < height.length;) {
            wallIndex = i + 1;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[wallIndex]) {
                    wallIndex = j;
                }
            }
            for (int j = wallIndex - 1; j > i; j--) {
                resultCount += (height[wallIndex] - height[j]);
            }
            i = wallIndex;
        }
        return resultCount;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}