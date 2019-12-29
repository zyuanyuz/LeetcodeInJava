package contest.contest169;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        boolean[] indexReach = new boolean[arr.length];
        return fillIndexReach(arr, indexReach, start);
    }

    private boolean fillIndexReach(int[] arr, boolean[] indexReach, int index) {
        if (arr[index] == 0)
            return true;
        indexReach[index] = true;
        if (index - arr[index] >= 0 && !indexReach[index - arr[index]]
                && fillIndexReach(arr, indexReach, index - arr[index])) {
            return true;
        }
        if (index + arr[index] < arr.length && !indexReach[index + arr[index]]
                && fillIndexReach(arr, indexReach, index + arr[index])) {
            return true;
        }
        return false;
    }

}