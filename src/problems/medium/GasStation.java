package problems.medium;

/**
 * leetcode 134 GasStation Medium
 */
public class GasStation {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
    //Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Gas Station.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasHave = 0;
        for (int start = 0; start < gas.length; start++) {
            if (cost[start] > gas[start]) {
                continue;
            }
            gasHave = gas[start] - cost[start];
            for (int station = start + 1; station != start; station++) {
                station %= gas.length;
                if (gasHave + gas[station] < cost[station]) {
                    start = start < station ? station : start;
                    break;
                }
                gasHave += gas[station] - cost[station];
                if ((start == 0 && station == gas.length - 1) || (station == start - 1)) {
                    return start;
                }
            }
        }
        return -1;
    }
}