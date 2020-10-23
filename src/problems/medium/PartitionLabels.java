package problems.medium;

/**
 * @author zyuanyuz
 * @since 2020/10/22 21:12
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leetcode 763
 */
public class PartitionLabels {
    /**
     * 执行用时：
     * 17 ms
     * , 在所有 Java 提交中击败了
     * 10.11%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 21.61%
     * 的用户
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        LinkedList<Range> ranges = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (S.chars().anyMatch(ch -> ch == c)) {
                int leftIndex = 0, rightIndex = S.length() - 1;
                for (int j = 0; j < S.length(); j++) {
                    if (S.charAt(j) == c) {
                        leftIndex = j;
                        break;
                    }
                }
                for (int j = S.length() - 1; j >= 0; j--) {
                    if (S.charAt(j) == c) {
                        rightIndex = j;
                        break;
                    }
                }
                Range r = new Range(leftIndex, rightIndex);
                if (ranges.isEmpty()) {
                    ranges.add(r);
                } else {
                    for (int j = 0; j < ranges.size(); j++) {
                        if (ranges.get(j).left > r.left) {
                            ranges.add(j, r);
                            break;
                        }
                        if (j == ranges.size() - 1) {
                            ranges.addLast(r);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < ranges.size(); ) {
            Range leftR = ranges.get(i);
            Range rightR;
            if (i < ranges.size() - 1 && leftR.right > (rightR = ranges.get(i + 1)).left) {
                if (rightR.right < leftR.right) {
                    ranges.remove(rightR);
                } else if (rightR.right > leftR.right) {
                    leftR.right = rightR.right;
                    ranges.remove(rightR);
                }
            } else {
                i++;
            }
        }
        return ranges.stream()
                .map(r -> r.right - r.left + 1)
                .collect(Collectors.toList());
    }

    private class Range {
        int left;
        int right;

        Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
