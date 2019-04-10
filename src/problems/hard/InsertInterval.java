package problems.hard;

import java.util.*;

/**
 * leetcode 57 Hard
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    //Runtime: 6 ms, faster than 89.16% of Java online submissions for Insert Interval.
    //Memory Usage: 41.9 MB, less than 5.08% of Java online submissions for Insert Interval.
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int index = 0;
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start == newInterval.start
                    && intervals.get(i).end < newInterval.end) {
                intervals.set(i, new Interval(intervals.get(i).start, newInterval.end));
                index = i;
                break;
            } else if (intervals.get(i).start == newInterval.start) {
                return intervals;
            } else if (newInterval.start < intervals.get(i).start) {
                intervals.add(i, newInterval);
                index = i;
                break;
            } else if (i == intervals.size() - 1) {
                intervals.add(newInterval);
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            result.add(intervals.get(i));
        }
        for (int i = index; i < intervals.size(); i++) {
            if (result.size() == 0) {
                result.add(intervals.get(i));
            } else if (result.get(result.size() - 1).end < intervals.get(i).start) {  //not overlap
                result.add(intervals.get(i));
            } else if (result.get(result.size() - 1).end < intervals.get(i).end) {
                result.set(result.size() - 1, new Interval(result.get(result.size() - 1).start,
                        intervals.get(i).end));
            }
        }
        return result;
    }

    public void test() {
        //[[1,5]] [2,3]
        //[[1,3],[6,9]] [2,5]
        Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(4, 5),
                new Interval(6, 7), new Interval(8, 9)};
        for (Interval interv : insert(new ArrayList<>(Arrays.asList(intervals)), new Interval(1, 10))) {
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
