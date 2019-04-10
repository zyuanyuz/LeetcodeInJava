package problems.medium;

import java.util.Arrays;

/**
 * leetcode 31 Medium
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {
	//11 ms, faster than 54.96% of Java online submissions for Next Permutation.
	public void nextPermutation(int[] nums) {
		int leng = 2; // 相应子数组的长度
		int tmp = 0; // 用于交换的暂时数
		while (leng <= nums.length) {
			if (nums[nums.length - leng] >= nums[nums.length - leng + 1]) { // 当前元素加入后是最大值，即顺序列
				leng++;
				continue;
			} else {
				int changepoint = nums.length - 1;
				// 找比新数大的最小数
				for (int i = nums.length - 1; i > nums.length - leng; i--) {
					if (nums[i] > nums[nums.length - leng]) {
						changepoint = i;
						break;
					}
				}
				// 交换首位数
				tmp = nums[changepoint];
				nums[changepoint] = nums[nums.length - leng];
				nums[nums.length - leng] = tmp;
				// 完成交换后返回结果
				break;
			}
		}
		// 对后面的数进行排序,只需首尾对称交换，若leng = nums.length,可以返回倒排结果
		int i = nums.length - leng + 1;
		int j = nums.length - 1;
		while (i < j) {
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}

	public void test() {
		int[] testnums = { 2, 4, 3, 1 };
		nextPermutation(testnums);
		for (int a : testnums) {
			System.out.print(a + " ");
		}
	}
}
