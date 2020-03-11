package problems.easy;

public class PartitionArrayIntoThreePartsWithEqualSum {

    /*
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 86.52% 的用户 内存消耗 : 43.9 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public boolean canThreePartsEqualSum(int[] A) {

        int allSum = 0, leftSum = 0, rightSum = 0, avgSum = 0;
        int leftIndex = 0, rightIndex = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            allSum += A[i];
        }
        if (allSum % 3 != 0) {
            return false;
        } else {
            avgSum = allSum / 3;
        }
        while (leftIndex <= rightIndex) {
            if (leftIndex > 0 && rightIndex < A.length - 1 && leftSum == avgSum && rightSum == avgSum) {
                return true;
            }
            if (leftSum != avgSum || leftIndex == 0) {
                leftSum += A[leftIndex++];
            }
            if (rightSum != avgSum || rightIndex == A.length - 1) {
                rightSum += A[rightIndex--];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionArrayIntoThreePartsWithEqualSum p = new PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(p.canThreePartsEqualSum(new int[] { 1, -1, 1, -1 }));
    }
}