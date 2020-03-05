package problems.easy;

public class DistributeCandiestoPeople {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 90.51% 的用户 内存消耗 : 37.2 MB , 在所有 Java 提交中击败了
     * 5.27% 的用户
     */
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 0) {
            return null;
        }
        int[] result = new int[num_people];
        int candiesPerTime = 1, arrayIndex = 0;
        while (candies > 0) {
            arrayIndex = arrayIndex % num_people;
            if (candies > candiesPerTime) {
                result[arrayIndex] += candiesPerTime;
                candies -= candiesPerTime;
            } else {
                result[arrayIndex] += candies;
                candies = 0;
            }
            candiesPerTime++;
            arrayIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        DistributeCandiestoPeople d = new DistributeCandiestoPeople();
        d.distributeCandies(2, 4);
    }
}