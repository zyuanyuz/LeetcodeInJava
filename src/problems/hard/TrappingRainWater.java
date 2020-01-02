package problems.hard;
//leetcode 42
//TODO fix bug
public class TrappingRainWater {
    /**
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
        int wallIndex = maxValueIndex;
        for (int i = maxValueIndex - 1; i > 0;) {
            for (int j = i; j > 0; j--) {
                if (height[j] >= wallIndex) {
                    wallIndex = j;
                }
            }
            for (int j = wallIndex + 1; j <= i; j++) {
                resultCount += (height[wallIndex] - height[j]);
            }
            i = wallIndex;
        }
        // ->
        wallIndex = maxValueIndex;
        for (int i = maxValueIndex + 1; i < height.length; i++) {
            for (int j = i; j < height.length; i++) {

            }
            for (int j = wallIndex - 1; j >= i; j--) {
                resultCount += (height[wallIndex] - height[j]);
            }
            i = wallIndex;
        }
        return resultCount;
    }
}