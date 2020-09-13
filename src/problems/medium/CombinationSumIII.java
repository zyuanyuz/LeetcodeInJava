package problems.medium;

/**
 * leetcode 216
 */
public class CombinationSumIII {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.3 MB , 在所有 Java 提交中击败了
     * 28.28% 的用户
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, result, new ArrayList<>(), 0, n, k);
        return result;
    }

    private void backtracking(int now, List<List<Integer>> result, List<Integer> nowList, int sumNow, int sumTarget,
            int sizeTarget) {
        if (sumNow == sumTarget && nowList.size() == sizeTarget) {
            result.add(new ArrayList<>(nowList));
        }
        if (now <= 9 && nowList.size() < sizeTarget && sumNow < sumTarget) {
            backtracking(now + 1, result, nowList, sumNow, sumTarget, sizeTarget);
            if (sumNow + now <= sumTarget) {
                nowList.add(now);
                sumNow += now;
                backtracking(now + 1, result, nowList, sumNow, sumTarget, sizeTarget);
                nowList.remove(nowList.size() - 1);
            }
        }
    }
}
