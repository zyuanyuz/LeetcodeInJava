package contest.contest166;

/**
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor and divide all the array by it and sum the result of
 * the division. Find the smallest divisor such that the result mentioned above
 * is less than or equal to threshold.
 * 
 * Each result of division is rounded to the nearest integer greater than or
 * equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 * It is guaranteed that there will be an answer.
 */
public class FindtheSmallestDivisorGivenaThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int sum = 0;
        int start = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
        }
        int end = max;
        while (start < end) {
            int pivot = (start + end) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= pivot) {
                    sum += 1;
                } else {
                    sum += (int) Math.ceil((double) nums[i] / (double) pivot);
                }
            }
            if (sum <= threshold) {
                end = pivot;
            } else {
                start = pivot + 1;
            }
            sum = 0;
        }
        return start;
    }

    public static void main(String[] args) {
        FindtheSmallestDivisorGivenaThreshold f = new FindtheSmallestDivisorGivenaThreshold();
        System.out.println(f.smallestDivisor(new int[] { 1, 2, 5, 9 }, 6));
    }
    // nums = [1,2,3], threshold = 6, answer = 1
    // nums = [1,2,5,9], threshold = 6, answer = 5
    // nums = [2,3,5,7,11], threshold = 11, answer = 3
    // nums = [19], threshold = 5, answer = 4
    // nums = [962551,933661,905225,923035,990560], threshold = 10, answer = 495280
    // nums =
    // [81488,78770,69737,14847,36203,85812,62771,25584,40434,55397,95643,48474,63802,63203,69258,16397,62134,68311,48931,4317,488,76613,70301,24052,67069,8018,61725,98992,86206,54407,33175,65597,5215,11866,9420,93851,66858,78097,70255,92021,50353,91451,52417,411,81332,27928,51842,83525,74458,10995,18792,14219,31190,86907,412,45731,9730,1258,94589,84673,20469,479,71501,68751,18230,77410,41662,9005,72532,36514,5203,528,59746,45580,72611,30386,40609,30783,70776,78765,97187,19997,16257,86367,80891,43219,55020,4753,2785,70141,86103,25092,50595,73151,69139,92893,18011,94848,65111,5657],
    // threshold = 988, answer = 5317
}