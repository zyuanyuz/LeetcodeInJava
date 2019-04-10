package problems.medium;

/**
 * leetcode 11:Medium 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 *	
 */

public class ContainerWithMostWater {
	//Brute Force,O(n^2)
	//370 ms, faster than 12.10% of Java online submissions for Container With Most Water.
	public int maxAreaone(int[] height) {
		int maxResult = 0;
		int nowArea = 0;
		int nowHeight = 0;
		for(int i=0;i<height.length-1;i++) {
			for(int j=i+1;j<height.length;j++) {
				nowHeight = height[i]>height[j]?height[j]:height[i];//选较小值 
				nowArea = nowHeight*(j-i);
				maxResult = nowArea>maxResult?nowArea:maxResult;
			}
		}
		
		return maxResult;
	}
	
	public int maxArea(int[] height) {
		
		return 0;
	}

	public void test() {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
