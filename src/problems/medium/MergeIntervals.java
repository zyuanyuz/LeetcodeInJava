package problems.medium;

import java.util.*;

/**
 * leetcode 56 Medium
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeIntervals {
    //Runtime: 220 ms, faster than 5.15% of Java online submissions for Merge Intervals.
    //Memory Usage: 52.7 MB, less than 5.03% of Java online submissions for Merge Intervals.
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<Interval> result = new ArrayList<>();  //允许节点乱序
        List<Interval> tmp = new ArrayList<>();
        tmp.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            for (int j = 0; j < tmp.size(); j++) {
                Interval intervoriginal = intervals.get(i);
                Interval intervintmp = tmp.get(j);
                if (intervoriginal.start == intervintmp.start && intervoriginal.end != intervintmp.end) {
                    tmp.set(j, new Interval(intervoriginal.start,
                            intervintmp.end > intervoriginal.end ? intervintmp.end : intervoriginal.end));
                    break;
                } else if (intervoriginal.start < intervintmp.start) {
                    tmp.add(j, intervoriginal);
                    break;
                } else if (j == tmp.size() - 1) {
                    tmp.add(intervoriginal);
                    break;
                }
            }
        }
        result.add(tmp.get(0));  //init the result
        for (int i = 1; i < tmp.size(); i++) {
            if (tmp.get(i).start > result.get(result.size() - 1).end) {   //not overlap
                result.add(tmp.get(i));
            } else if (tmp.get(i).end > result.get(result.size() - 1).end) {
                result.set(result.size() - 1,
                        new Interval(result.get(result.size() - 1).start, tmp.get(i).end));
            }
        }
        return result;
    }

    public void test() {
        //[2,3],[4,5],[6,7],[8,9],[1,10]
        //
        Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(4, 5),
                new Interval(6, 7), new Interval(8, 9), new Interval(1, 10)};
        for (Interval interv : merge(new ArrayList<>(Arrays.asList(intervals)))) {
            System.out.print(interv.start + " " + interv.end);
            System.out.println();
        }
    }


    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
