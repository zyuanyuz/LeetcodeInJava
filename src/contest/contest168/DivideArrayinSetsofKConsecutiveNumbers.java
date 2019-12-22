package contest.contest168;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayinSetsofKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> dataStore = new HashMap<>();
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (minValue > nums[i]) {
                minValue = nums[i];
            }
            if (maxValue < nums[i]) {
                maxValue = nums[i];
            }
            if (dataStore.get(nums[i]) == null) {
                dataStore.put(nums[i], 0);
            }
            int now = dataStore.get(nums[i]);
            dataStore.put(nums[i], now + 1);
        }

        for (int i = minValue; i <= maxValue - k + 1;) {
            if (dataStore.get(i) == null || dataStore.get(i) == 0) {
                i++;
                continue;
            }
            for (int j = i; j < i + k; j++) {
                if (dataStore.get(j) == null || dataStore.get(j) == 0) {
                    return false;
                }
                dataStore.put(j, dataStore.get(j) - 1);
            }
            if (dataStore.get(i) == 0) {
                i++;
            }
        }
        for (int key : dataStore.keySet()) {
            if (dataStore.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DivideArrayinSetsofKConsecutiveNumbers d = new DivideArrayinSetsofKConsecutiveNumbers();
        int[] nums = new int[] { 1, 2, 3, 3, 4, 4, 5, 6 };
        int k = 4;
        d.isPossibleDivide(nums, k);
    }
}