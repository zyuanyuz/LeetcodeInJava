package problems.medium;

//leetcode 153

public class FindMinimuminRotatedSortedArray {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了
     * 5.55% 的用户
     */
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int leftIndex = 0, rightIndex = nums.length - 1;
        for (; leftIndex < rightIndex;) {
            if (leftIndex == rightIndex - 1) {
                return Integer.min(nums[leftIndex], nums[rightIndex]);
            }
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[leftIndex] > nums[mid]) {
                rightIndex = mid;
                continue;
            } else if (nums[mid] > nums[rightIndex]) {
                leftIndex = mid;
            }
        }
        return nums[leftIndex];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        System.out.println(f.findMin(new int[] { 3, 4, 5, 0, 1, 2 }));
    }
}