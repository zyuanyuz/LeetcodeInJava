package problems.easy;

/**
 * @author zyuanyuz
 * @since 2020/10/26 21:39
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1365
 */
public class HowManyNumbersAreSmallerThantheCurrentNumber {
    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 64.02%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 98.66%
     * 的用户
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], new ArrayList<>());
            }
            m.get(nums[i]).add(i);
        }
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ) {
            List<Integer> indexList = m.get(nums[i]);
            for (int index : indexList) {
                result[index] = i;
            }
            i += indexList.size();
        }
        return result;
    }
}
