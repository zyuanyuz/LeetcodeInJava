package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
    /**
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 26.38% 的用户 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了
     * 61.96% 的用户
     */
    public int orangesRotting(int[][] grid) {
        int oranges = 0, rottOranges = 0;
        int timeCount = 0;
        int rottPerTime;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    oranges++;
                }
                if (grid[i][j] == 2) {
                    oranges++;
                    rottOranges++;
                }
            }
        }

        do {
            rottPerTime = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            list.add(i - 1);
                            list.add(j);
                            rottPerTime++;
                        }

                        if (j > 0 && grid[i][j - 1] == 1) {
                            list.add(i);
                            list.add(j - 1);
                            rottPerTime++;
                        }

                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            list.add(i + 1);
                            list.add(j);
                            rottPerTime++;
                        }

                        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                            list.add(i);
                            list.add(j + 1);
                            rottPerTime++;
                        }
                    }
                }
            }
            if (rottPerTime > 0) {
                timeCount++;
                for (int i = 0; i < list.size() - 1; i += 2) {
                    if (grid[list.get(i)][list.get(i + 1)] == 1) {
                        grid[list.get(i)][list.get(i + 1)] = 2;
                        rottOranges++;
                    }
                }
            }
        } while (rottPerTime > 0 && oranges > rottOranges);
        System.out.println(oranges + " " + rottOranges + " " + timeCount);
        return oranges == rottOranges ? timeCount : -1;
    }
}