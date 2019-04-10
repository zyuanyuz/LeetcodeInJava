package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47 Medium
 * <p>
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class PermutationsII {
    //Runtime: 35 ms, faster than 17.48% of Java online submissions for Permutations II.
    //Memory Usage: 41.6 MB, less than 17.45% of Java online submissions for Permutations II.
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, nums.length, 0);
        return result;
    }

    //needs to consider when the overlap will happen
    public void backtracking(List<List<Integer>> result, int[] nums, int allN, int n) {
        if (n == allN) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < allN; i++) {
                list.add(nums[i]);
            }
//            result.add(list);
            //find the mistake
            boolean isExist = false;
            boolean isRealExist = false;
            for(List<Integer> nowList:result){
                for(int i=0;i<allN;i++){
                    if(list.get(i).equals(nowList.get(i))){
                        if(i==allN-1){
                            isRealExist = true;
                        }
                        isExist = true;
                        continue;
                    }else{
                        isExist = false;
                        break;
                    }
                }
                if(isExist){
                    System.out.println(nowList);
                }
            }
            if(!isRealExist){
                result.add(list);
            }
        }

        for (int i = n; i < allN; i++) {
            if (i != n && (nums[i] == nums[i - 1] || (nums[i] == nums[n]))) {
                continue;
            }
            int tmp = nums[n];
            nums[n] = nums[i];
            nums[i] = tmp;
            backtracking(result, nums, allN, n + 1);
            tmp = nums[n];    //exchange back
            nums[n] = nums[i];
            nums[i] = tmp;
        }
    }

    public void test() {
        // 0, 0, 1, 0, 9 resultWillSize:
        // 0, 0, 0, 1, 1 resultWillSize:10
        // 0, 0, 1, 1, 2, 2 resultWilleSize:90
        // 0 ,0, 1, 1, 2, 2, 3 resultWillSize:630
        //-1, 2, 0, -1, 1, 0, 1 resultWillSize:630
        int[] nums = new int[]{0 ,0, 1, 1, 2, 2, 3};
        System.out.println(permuteUnique(nums).size());
    }
}
