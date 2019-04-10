package problems.easy;

/**
 * leetcoode 88 MergeSortedArray Easy
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    //Runtime: 1 ms, faster than 95.47% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 37.3 MB, less than 86.51% of Java online submissions for Merge Sorted Array.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        //insertSort
        for (int i = 1; i < m + n; i++) {
            int tmp = nums1[i];
            for (int j = i - 1; j >= -1; j--) {
                if (j >= 0 && tmp < nums1[j]) {
                    nums1[j + 1] = nums1[j];
                } else {
                    nums1[j + 1] = tmp;
                    break;
                }
            }
        }
    }

    public void test() {
        //[2,0]
        //1
        //[1]
        //1
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        for (int num : nums1) {
            System.out.print(num + "\t");
        }
    }
}
