package problems.medium;

/**
 * leetcode 80 RemoveDuplicatesfromSortedArrayII Medium
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesfromSortedArrayII {
    //Runtime: 1 ms, faster than 99.72% of Java online submissions for Remove Duplicates from Sorted Array II.
    //Memory Usage: 38.4 MB, less than 93.40% of Java online submissions for Remove Duplicates from Sorted Array II.
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int indexExchange = 1, indexForward = 1, count = 1;
        //most important: indexForward should compare with indexForward -1
        while (indexForward < nums.length) {
            //best step!
            while (indexForward < nums.length
                    && nums[indexForward] == nums[indexForward - 1] && count < 2) {
                nums[indexExchange++] = nums[indexForward++];
                count++;
            }
            while (indexForward < nums.length
                    && nums[indexForward] == nums[indexForward - 1]) {
                indexForward++;
            }
            if (indexForward >= nums.length) break;
            nums[indexExchange++] = nums[indexForward++];
            count = 1;
        }
        return indexExchange;
    }

    public void test() {
        int[] nums = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
